package scoreboard;

import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class ScoreboardConsole {
	private final PrintWriter writer;
	private final Scoreboard scoreboard;

	public ScoreboardConsole(PrintWriter writer, Scoreboard scoreboard) {
		this.writer = writer;
		this.scoreboard = scoreboard;
	}

	public void start() {
		showScore();
	}

	private void showScore() {
		writer.println(String.format("%03d:%03d", scoreboard.scoreTeamA(), scoreboard.scoreTeamB()));
	}
}
