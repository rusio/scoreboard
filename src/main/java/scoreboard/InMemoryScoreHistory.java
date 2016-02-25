
package scoreboard;

import java.util.EmptyStackException;
import java.util.Stack;

public class InMemoryScoreHistory implements ScoreHistory {

	private Stack<Score> scores = new Stack<>();

	@Override
	public void save(int scoreA, int scoreB) {
		scores.push(new Score(scoreA, scoreB));
	}

	@Override
	public int[] pop() {
		try {
			return scores.pop().toIntArray();
		}
		catch (EmptyStackException ignore) {
			return ZERO_SCORE;
		}
	}

	public void clear() {
		scores.clear();
	}

	private static class Score {

		private final int scoreA;
		private final int scoreB;

		private Score(int scoreA, int scoreB) {
			this.scoreA = scoreA;
			this.scoreB = scoreB;
		}

		private int[] toIntArray() {
			return new int[] { scoreA, scoreB };
		}
	}
}
