package scoreboard;

import static org.mockito.Mockito.mock;

import java.io.IOException;
import java.io.PrintStream;

import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import scoreboard.api.Command;
import scoreboard.api.CommandExecutor;

public class DisplayTest {
	private PrintStream console = mock(PrintStream.class);
	private InOrder inOrder = Mockito.inOrder(console);
	private ScoreDisplay display = new ScoreDisplay(console);
	private CommandExecutor scoreBoard = new Scoreboard(display);

	@Test
	public void displayScores() throws IOException {
		inOrder.verify(console).println("000 : 000");
		scoreBoard.execute(Command.IncreaseA);
		inOrder.verify(console).println("001 : 000");
		scoreBoard.execute(Command.IncreaseB);
		inOrder.verify(console).println("001 : 001");
	}
}
