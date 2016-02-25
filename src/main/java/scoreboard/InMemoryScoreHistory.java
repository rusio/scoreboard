package scoreboard;

public class InMemoryScoreHistory implements ScoreHistory{
	@Override
	public void save(int scoreA, int scoreB) {

	}

	@Override
	public int[] pop() {
		return new int[] {0, 0};
	}
}
