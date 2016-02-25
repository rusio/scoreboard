package scoreboard;

public interface ScoreHistory {
	int[] ZERO_SCORE = new int[] { 0, 0 };

	void save(int scoreA, int scoreB);

	int[] pop();

	void clear();
}
