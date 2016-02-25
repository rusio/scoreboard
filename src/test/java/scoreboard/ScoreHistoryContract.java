package scoreboard;

import junit5.helpers.ArrayAssertions;

import org.junit.gen5.api.Test;

interface ScoreHistoryContract {

	ScoreHistory emptyHistory();

	@Test
	default void emptyHistoryWillReturnZeroScore() {
		ArrayAssertions.assertArrayEquals(ScoreHistory.ZERO_SCORE, emptyHistory().pop());
	}

	@Test
	default void savedScoreCanBePopped() {
		ScoreHistory history = emptyHistory();
		history.save(19, 22);
		ArrayAssertions.assertArrayEquals(new int[] { 19, 22 }, history.pop());
	}

	@Test
	default void manySavedScoresWillBePoppedInReverseOrder() {
		ScoreHistory history = emptyHistory();
		history.save(1, 11);
		history.save(2, 22);
		history.save(3, 33);
		ArrayAssertions.assertArrayEquals(new int[] { 3, 33 }, history.pop());
		ArrayAssertions.assertArrayEquals(new int[] { 2, 22 }, history.pop());
		ArrayAssertions.assertArrayEquals(new int[] { 1, 11 }, history.pop());
	}

	@Test
	default void afterClearHistoryWillReturnZeroScore() {
		ScoreHistory history = emptyHistory();
		history.save(1, 11);
		history.clear();
		ArrayAssertions.assertArrayEquals(ScoreHistory.ZERO_SCORE, history.pop());
	}
}
