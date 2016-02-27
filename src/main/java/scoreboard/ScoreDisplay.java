package scoreboard;

import java.io.PrintStream;

public class ScoreDisplay implements ScoreListener {

	private PrintStream console;

	public ScoreDisplay(PrintStream console) {
		this.console = console;

	}

	@Override
	public void onScoreChanged(int scoreA, int scoreB) {
		console.println(String.format("%03d : %03d", scoreA, scoreB));
	}

}
