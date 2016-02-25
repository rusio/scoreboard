
package scoreboard;

import static org.junit.gen5.api.Assertions.*;

import org.junit.gen5.api.Test;

class ScoreboardTests {

	@Test
	void aNewBoard() {
		Scoreboard board = new Scoreboard();
		assertAll("current score", //
			() -> assertEquals(0, board.scoreTeamA(), "team A"), //
			() -> assertEquals(0, board.scoreTeamB(), "team B") //
		);
	}
}
