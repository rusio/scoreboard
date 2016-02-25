
package scoreboard;

class InMemoryScoreHistoryTests implements ScoreHistoryContract {

	@Override
	public ScoreHistory emptyHistory() {
		return new InMemoryScoreHistory();
	}

}
