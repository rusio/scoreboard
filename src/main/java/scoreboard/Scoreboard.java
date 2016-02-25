
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
		switch (command) {
			case INC_A:
				history.save(scoreA, scoreB);
				scoreA++;
				break;
			case INC_B:
				history.save(scoreA, scoreB);
				scoreB++;
				break;
			case REVERT:
				int[] score = history.pop();
				scoreA = score[0];
				scoreB = score[1];
				break;
		}
		display.displayScore(scoreA, scoreB);
	}
}
