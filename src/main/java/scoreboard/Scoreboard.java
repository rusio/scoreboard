package scoreboard;

import scoreboard.api.Command;
import scoreboard.api.CommandExecutor;
import scoreboard.api.ScoreListener;

public class Scoreboard implements CommandExecutor {

	private int scoreA;
	private int scoreB;

	private ScoreListener scoreListener;
	
	public Scoreboard(ScoreListener scoreListener) {
		ScoreListener dummyScoreListener = (scoreA, scoreB) -> {};
		this.scoreListener = (scoreListener == null) ? dummyScoreListener : scoreListener;
		this.scoreListener.onScoreChanged(scoreA, scoreB);
	}

	public int getScoreA() {
		return this.scoreA;
	}

	public int getScoreB() {
		return this.scoreB;
	}

	private void reset() {
		this.scoreA = 0;
		this.scoreB = 0;
	}
	
	@Override
	public void execute(Command command) {
		switch (command) {
		case IncreaseA:
			this.scoreA++;
			break;
		case IncreaseB:
			this.scoreB++;
			break;
		case DecreaseA: 
			if (this.scoreA > 0) {
				this.scoreA--;
			}
			break;
		case DecreaseB: 
			if (this.scoreB > 0) {
				this.scoreB--;
			}
			break;
		case Reset:
			reset();
			break;
		default:
			break;
		}
		scoreListener.onScoreChanged(scoreA, scoreB);
	}
	
}
