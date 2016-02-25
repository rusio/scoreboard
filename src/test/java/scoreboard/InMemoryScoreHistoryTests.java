package scoreboard;

import org.junit.gen5.api.Test;

import junit5.helpers.ArrayAssertions;

class InMemoryScoreHistoryTests {

	InMemoryScoreHistory history = new InMemoryScoreHistory();

	@Test
	void emptyHistoryWillReturnZeroScore() {
		ArrayAssertions.assertArrayEquals(ScoreHistory.ZERO_SCORE, history.pop());
	}

	@Test
	void savedScoreCanBePopped() {
		history.save(19, 22);
		ArrayAssertions.assertArrayEquals(new int[] { 19, 22 }, history.pop());
	}

	@Test
	void manySavedScoresWillBePoppedInReverseOrder() {
		history.save(1, 11);
		history.save(2, 22);
		history.save(3, 33);
		ArrayAssertions.assertArrayEquals(new int[] { 3, 33 }, history.pop());
		ArrayAssertions.assertArrayEquals(new int[] { 2, 22 }, history.pop());
		ArrayAssertions.assertArrayEquals(new int[] { 1, 11 }, history.pop());
	}

	@Test
	void afterClearHistoryWillReturnZeroScore() {
		history.save(1, 11);
		history.clear();
		ArrayAssertions.assertArrayEquals(ScoreHistory.ZERO_SCORE, history.pop());
	}
}
