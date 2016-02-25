
package scoreboard;

import static org.junit.gen5.api.Assertions.*;

import org.junit.gen5.api.Test;

class ScoreboardTests {

	Scoreboard board = new Scoreboard();

	@Test
	void aNewBoard() {
		assertScore(0, 0);
	}

	@Test
	void increaseScoreOfTeamA() {
		board.plusTeamA();
		assertScore(1, 0);
	}

	@Test
	void increaseScoreOfTeamB() {
		board.plusTeamB();
		assertScore(0, 1);
	}

	private void assertScore(int expectedScoreA, int expectedScoreB) {
		assertAll("current score", //
				() -> assertEquals(expectedScoreA, board.scoreTeamA(), "team A"), //
				() -> assertEquals(expectedScoreB, board.scoreTeamB(), "team B") //
		);
	}

}
