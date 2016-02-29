package scoreboard;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import scoreboard.api.Command;
import scoreboard.api.CommandExecutor;

public class ScoreBoardHistoryTests {
	private Scoreboard board = new Scoreboard(null);
	private CommandExecutor executor = new HistoryExecutor(board);

	@Test
	public void rewind() throws Exception {
		executor.execute(Command.IncreaseA);
		executor.execute(Command.IncreaseA);
		executor.execute(Command.DecreaseA);
		executor.execute(Command.IncreaseB);
		executor.execute(Command.IncreaseB);
		executor.execute(Command.DecreaseB);
		assertScores(1, 1);
		executor.execute(Command.Rewind);
		assertScores(1, 2);
		executor.execute(Command.Rewind);
		assertScores(1, 1);
		executor.execute(Command.Rewind);
		assertScores(1, 0);
		executor.execute(Command.Rewind);
		assertScores(2, 0);
		executor.execute(Command.Rewind);
		assertScores(1, 0);
		executor.execute(Command.Rewind);
		assertScores(0, 0);
		assertHistoryEmpty();
	}
	
	private void assertScores(int expectedScoreA, int expectedScoreB) {
		assertEquals(expectedScoreA, board.getScoreA());
		assertEquals(expectedScoreB, board.getScoreB());
	}
	
	@Test
	public void reset() throws Exception {
		executor.execute(Command.IncreaseA);
		executor.execute(Command.IncreaseB);
		executor.execute(Command.DecreaseB);
		executor.execute(Command.Reset);
		assertScores(0, 0);
		assertHistoryEmpty();
	}
	
	private void assertHistoryEmpty() {
		int scoreA = board.getScoreA();
		int scoreB = board.getScoreB();
		executor.execute(Command.Rewind);
		assertEquals(scoreA, board.getScoreA());
		assertEquals(scoreB, board.getScoreB());
	}
}
