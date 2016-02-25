
package scoreboard;

public class Scoreboard {

	private ScoreDisplay display;

	private int scoreA = 0;
	private int scoreB = 0;

	public void registerDisplay(ScoreDisplay display) {
		display.displayScore(scoreA, scoreB);
		this.display = display;
	}

	public void send(Command command) {
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
