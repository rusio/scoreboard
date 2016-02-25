package scoreboard;

public class Scoreboard {

	private int scoreTeamA = 0;

	public int scoreTeamA() {
		return scoreTeamA;
	}

	public int scoreTeamB() {
		return 0;
	}

	public void plusTeamA() {
		scoreTeamA++;
	}
}
