
package scoreboard;

import static org.mockito.Mockito.verify;

import junit5.helpers.InjectMock;
import junit5.helpers.MockitoExtension;

import org.junit.gen5.api.Test;
import org.junit.gen5.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
class ScoreboardTests {

	@Test
	void aNewBoardDisplaysInitialScore(@InjectMock ScoreDisplay display) {
		Scoreboard board = new Scoreboard();
		board.registerDisplay(display);

		verify(display).displayScore(0, 0);
	}
}
