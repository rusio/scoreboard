package scoreboard;

public interface ScoreHistory {
	void save(int scoreA, int scoreB);

	int[] pop();
}
