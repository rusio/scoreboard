
package scoreboard;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

import junit5.helpers.InjectMock;
import junit5.helpers.MockitoExtension;

import org.junit.gen5.api.BeforeEach;
import org.junit.gen5.api.Test;
import org.junit.gen5.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;

@ExtendWith(MockitoExtension.class)
class ScoreboardTests {

	Scoreboard board;

	@Mock
	ScoreHistory history;

	@BeforeEach
	void init() {
		board = new Scoreboard(history);
	}

	@Test
	void registeringADisplayWillDisplayCurrentScore(@InjectMock ScoreDisplay display) {
		board.registerDisplay(display);

		verify(display).displayScore(0, 0);
	}

	@Test
	void teamAPlusWillDisplayIncreasedScore(@InjectMock ScoreDisplay display) {
		board.registerDisplay(display);
		reset(display);

		board.send(Command.INC_A);

		verify(display).displayScore(1, 0);
	}

	@Test
	void teamBPlusWillDisplayIncreasedScore(@InjectMock ScoreDisplay display) {
		board.registerDisplay(display);
		reset(display);

		board.send(Command.INC_B);

		verify(display).displayScore(0, 1);
	}

	@Test
	void increasingScoreWillTriggerHistorySaveWithPreviousScore() {
		board.send(Command.INC_A);
		board.send(Command.INC_B);
		board.send(Command.INC_A);

		InOrder inOrder = Mockito.inOrder(history);
		inOrder.verify(history).save(0, 0);
		inOrder.verify(history).save(1, 0);
		inOrder.verify(history).save(1, 1);
	}

	@Test
	void revertCommandGetsLatestScoreFromHistoryAndDisplaysIt(@InjectMock ScoreDisplay display) {
		when(history.pop()).thenReturn(new int[] { 42, 41 });
		board.registerDisplay(display);
		reset(display);

		board.send(Command.REVERT);
		verify(display).displayScore(42, 41);

		verify(history, never()).save(anyInt(), anyInt());
	}
}
