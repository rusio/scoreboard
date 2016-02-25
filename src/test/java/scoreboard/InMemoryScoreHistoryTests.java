package scoreboard;

import org.junit.gen5.api.Assertions;
import org.junit.gen5.api.Test;

import junit5.helpers.ArrayAssertions;

class InMemoryScoreHistoryTests {

	@Test
	void emptyHistoryWillReturnZeroScore() {
		InMemoryScoreHistory history = new InMemoryScoreHistory();
		ArrayAssertions.assertArrayEquals(new int[] {0, 0}, history.pop());
	}

}
