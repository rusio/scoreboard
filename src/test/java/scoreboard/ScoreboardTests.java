
package scoreboard;

import static org.mockito.Mockito.verify;

import junit5.helpers.InjectMock;
import junit5.helpers.MockitoExtension;

import org.junit.gen5.api.BeforeEach;
import org.junit.gen5.api.Test;
import org.junit.gen5.api.extension.ExtendWith;
import org.mockito.Mockito;

@ExtendWith(MockitoExtension.class)
class ScoreboardTests {

	Scoreboard board = new Scoreboard();

	@Test
	void registeringADisplayWillDisplayCurrentScore(@InjectMock ScoreDisplay display) {
		board.registerDisplay(display);

		verify(display).displayScore(0, 0);
	}

	@Test
	void teamAPlusWillDisplayIncreasedScore(@InjectMock ScoreDisplay display) {
		board.registerDisplay(display);
		Mockito.reset(display);

		board.send(Command.INC_A);

		verify(display).displayScore(1, 0);
	}
}
