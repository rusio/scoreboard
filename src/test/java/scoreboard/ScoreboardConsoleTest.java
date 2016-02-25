package scoreboard;

import static org.junit.gen5.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;

import org.junit.gen5.api.Test;
import org.junit.gen5.api.extension.ExtendWith;
import org.mockito.Mockito;

import junit5.helpers.InjectMock;
import junit5.helpers.MockitoExtension;

class ScoreboardConsoleTest {

	@Test
	void startingConsoleShowsInitialScore() throws Exception {
		StringWriter stringWriter = new StringWriter();
		PrintWriter writer = new PrintWriter(stringWriter);
		ScoreboardConsole console = new ScoreboardConsole(writer, new Scoreboard());
		console.start();
		assertEquals("000:000" + System.lineSeparator(), stringWriter.toString());
	}
}
