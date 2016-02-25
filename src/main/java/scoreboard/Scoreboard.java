
package scoreboard;

public class Scoreboard {

	private final ScoreHistory history;
	private ScoreDisplay display = ScoreDisplay.NULL;

	private int scoreA = 0;
	private int scoreB = 0;

	public Scoreboard(ScoreHistory history) {
		this.history = history;
	}

	public void registerDisplay(ScoreDisplay display) {
		display.displayScore(scoreA, scoreB);
		this.display = display;
	}

	public void send(Command command) {
		history.save(scoreA, scoreB);
		switch (command) {
			case INC_A:
				scoreA++;
				break;
			case INC_B:
				scoreB++;
				break;
		}
		display.displayScore(scoreA, scoreB);
	}
}
