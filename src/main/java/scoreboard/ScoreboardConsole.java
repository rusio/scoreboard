
package scoreboard;

import java.io.PrintWriter;
import java.util.Scanner;

public class ScoreboardConsole {
	private final PrintWriter writer;
	private final Scoreboard scoreboard;

	public static void main(String[] args) {
		Scoreboard scoreboard = new Scoreboard(new InMemoryScoreHistory());
		ScoreboardConsole console = new ScoreboardConsole(new PrintWriter(System.out), scoreboard);
		console.start(new Scanner(System.in));
	}

	public ScoreboardConsole(PrintWriter writer, Scoreboard scoreboard) {
		this.writer = writer;
		this.scoreboard = scoreboard;
	}

	public void start(Scanner scanner) {
		scoreboard.registerDisplay(new Display());
		while(scanner.hasNext()) {
			String command = scanner.next();
			if ("a+".equalsIgnoreCase(command)) {
				scoreboard.send(Command.INC_A);
			}
			if ("b+".equalsIgnoreCase(command)) {
				scoreboard.send(Command.INC_B);
			}
			if ("r".equalsIgnoreCase(command)) {
				scoreboard.send(Command.REVERT);
			}
			if ("q".equalsIgnoreCase(command)) {
				break;
			}
		}
	}

	private class Display implements ScoreDisplay {
		@Override
		public void displayScore(int scoreA, int scoreB) {
			writer.println(String.format("%03d:%03d", scoreA, scoreB));
			writer.flush();
		}
	}
}
