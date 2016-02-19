package scoreboard;

import static org.junit.gen5.api.Assertions.*;

import org.junit.gen5.api.Assertions;
import org.junit.gen5.api.Test;

class ScoreboardTests {

	@Test
	void aNewBoard() throws Exception {
		assertNotNull(new Scoreboard());
	}
}
