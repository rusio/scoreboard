
package scoreboard;

import java.io.PrintWriter;
import java.util.Scanner;

public class ScoreboardConsole {
	private final PrintWriter writer;
	private final Scoreboard scoreboard;

	public static void main(String[] args) {
		ScoreboardConsole console = new ScoreboardConsole(new PrintWriter(System.out), new Scoreboard());
		console.start(new Scanner(System.in));
	}

	public ScoreboardConsole(PrintWriter writer, Scoreboard scoreboard) {
		this.writer = writer;
		this.scoreboard = scoreboard;
	}

	public void start(Scanner scanner) {
		showScore();
		while(scanner.hasNext()) {
			String command = scanner.next();
			if ("a+".equals(command)) {
				scoreboard.plusTeamA();
				showScore();
			}
		}
	}

	private void showScore() {
		writer.println(String.format("%03d:%03d", scoreboard.scoreTeamA(), scoreboard.scoreTeamB()));
		writer.flush();
	}
}
