package scoreboard;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.mockito.InOrder;

import scoreboard.api.Command;
import scoreboard.api.CommandExecutor;

public class HistoryExecutorTest {

	@Test
	public void writeAndReadHistory() throws IOException {
		File historyFile = new File("target/history");
		historyFile.delete();
		writeHistory(historyFile);
		readHistory(historyFile);
		historyFile.delete();
	}

	private void writeHistory(File historyFile) throws IOException {
		CommandExecutor executor = mock(CommandExecutor.class);
		InOrder inOrder = inOrder(executor);
		HistoryExecutor history = new HistoryExecutor(executor);
		history.execute(Command.IncreaseA);
		history.execute(Command.IncreaseB);
		inOrder.verify(executor).execute(Command.IncreaseA);
		inOrder.verify(executor).execute(Command.IncreaseB);
		history.write(historyFile);
	}
	
	private void readHistory(File historyFile) throws IOException {
		CommandExecutor executor = mock(CommandExecutor.class);
		InOrder inOrder = inOrder(executor);
		HistoryExecutor history = new HistoryExecutor(executor);
		history.replay(historyFile);
		inOrder.verify(executor).execute(Command.IncreaseA);
		inOrder.verify(executor).execute(Command.IncreaseB);
	}

}
