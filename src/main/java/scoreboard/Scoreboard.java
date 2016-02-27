package scoreboard;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Scoreboard {
	private Stack<Command> history;
	private int scoreA;
	private int scoreB;
	private Map<Command, Command> reverse;
	private ScoreListener scoreListener;
	
	public Scoreboard(ScoreListener scoreListener) {
		this.scoreListener = scoreListener;
		this.history = new Stack<>();
		initReverseMap();
		scoreListener.onScoreChanged(scoreA, scoreB);
	}

	private void initReverseMap() {
		this.reverse = new HashMap<>();
		this.reverse.put(Command.IncreaseA, Command.DecreaseA);
		this.reverse.put(Command.IncreaseB, Command.DecreaseB);
		this.reverse.put(Command.DecreaseA, Command.IncreaseA);
		this.reverse.put(Command.DecreaseB, Command.IncreaseB);
	}

	public int getScoreA() {
		return this.scoreA;
	}

	public int getScoreB() {
		return this.scoreB;
	}

	public void reset() {
		this.scoreA = 0;
		this.scoreB = 0;
		this.history.clear();
	}
	
	public void execute(Command command) {
		executeNoHist(command);
		this.history.add(command);
	}
	
	public void executeNoHist(Command command) {
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
		default:
			break;
		}
		scoreListener.onScoreChanged(scoreA, scoreB);
	}

	public void rewind() {
		if (!this.history.empty()) {
			executeNoHist(reverse.get(this.history.pop()));
		}
	}
}
