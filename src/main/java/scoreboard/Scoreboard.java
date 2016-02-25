package scoreboard;

public class Scoreboard {

	private int scoreTeamA = 0;
	private int scoreTeamB = 0;

	public int scoreTeamA() {
		return scoreTeamA;
	}

	public int scoreTeamB() {
		return scoreTeamB;
	}

	public void plusTeamA() {
		scoreTeamA++;
	}

	public void plusTeamB() {
		scoreTeamB++;
	}
}
