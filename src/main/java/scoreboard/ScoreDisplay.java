package scoreboard;

public interface ScoreDisplay {
	void displayScore(int scoreA, int scoreB);

	ScoreDisplay NULL = new ScoreDisplay() {
		@Override
		public void displayScore(int scoreA, int scoreB) {
		}
	};
}
