
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
		assertEquals("000:000" + System.lineSeparator(), stringWriter.toString());
	}
}
