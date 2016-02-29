package scoreboard;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import scoreboard.api.ScoreListener;

public class ScoreWriter implements ScoreListener {

	private ScoreListener chainedListener;
	private File scorefile;

	public ScoreWriter(File scorefile, ScoreListener chainedListener) {
		this.scorefile = scorefile;
		this.chainedListener = chainedListener;
	}

	@Override
	public void onScoreChanged(int scoreA, int scoreB) {
		try {
			PrintStream out = new PrintStream(new FileOutputStream(scorefile));
			out.println(String.format("%d,%d", scoreA, scoreB));
			out.close();
		} catch (FileNotFoundException e) {
			
		}
		this.chainedListener.onScoreChanged(scoreA, scoreB);
	}

}
