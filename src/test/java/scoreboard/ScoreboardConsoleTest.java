
package scoreboard;

import static org.junit.gen5.api.Assertions.assertEquals;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;

import org.junit.gen5.api.Test;

class ScoreboardConsoleTest {

	StringWriter stringWriter = new StringWriter();
	PrintWriter writer = new PrintWriter(stringWriter);
	ScoreboardConsole console = new ScoreboardConsole(writer, new Scoreboard());

	@Test
	void startingConsoleShowsInitialScore() throws Exception {
		console.start(new Scanner(""));
		assertEquals("000:000", getLastOutputLine());
	}


	@Test
	void pressingAandPlusIncreasesScoreOfTeamA() throws Exception {
		console.start(new Scanner("a+"));
		assertEquals("001:000", getLastOutputLine());
	}

	private String getLastOutputLine() {
		String[] allOutputLines = stringWriter.toString().split(System.lineSeparator());
		return allOutputLines[allOutputLines.length - 1];
	}
}
