package scoreboard;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.mockito.InOrder;

public class ScoreboardTests {
	private ScoreListener scoreListener = mock(ScoreListener.class);
	private InOrder inOrder = inOrder(scoreListener);
	private Scoreboard board = new Scoreboard(scoreListener);

	@Test
	public void increaseDecreaseA() throws Exception {
		assertScores(0, 0);
		board.execute(Command.IncreaseA);
		assertScores(1, 0);
		board.execute(Command.DecreaseA);
		assertScores(0, 0);
		// check score always >= 0
		board.execute(Command.DecreaseA);
		assertScores(0, 0);
	}
	
	@Test
	public void increaseDecreaseB() throws Exception {
		assertScores(0, 0);
		board.execute(Command.IncreaseB);
		assertScores(0, 1);
		board.execute(Command.DecreaseB);
		assertScores(0, 0);
		// check score always >= 0
		board.execute(Command.DecreaseB);
		assertScores(0, 0);
	}
	
	@Test
	public void increaseAincreaseB() throws Exception {
		board.execute(Command.IncreaseA);
		board.execute(Command.IncreaseB);
		assertScores(1, 1);
	}
	
	@Test
	public void reset() throws Exception {
		board.execute(Command.IncreaseA);
		board.execute(Command.Reset);
		assertScores(0, 0);
	}
	
	@Test
	public void scoreListener() {
		inOrder.verify(scoreListener).onScoreChanged(0, 0);
		board.execute(Command.IncreaseA);
		inOrder.verify(scoreListener).onScoreChanged(1, 0);
	}

	private void assertScores(int expectedScoreA, int expectedScoreB) {
		assertEquals(expectedScoreA, board.getScoreA());
		assertEquals(expectedScoreB, board.getScoreB());
	}
}
