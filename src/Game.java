public class Game {

    private Team team1;
    private Team team2;
    private int noOfBalls;

    private Team tossWinningTeam;

    private Team battingTeam;

    private Team bowlingTeam;

    public Team getTossWinningTeam() {
        return tossWinningTeam;
    }

    public void setTossWinningTeam(Team tossWinningTeam) {
        this.tossWinningTeam = tossWinningTeam;
    }

    public Team getBattingTeam() {
        return battingTeam;
    }

    public void setBattingTeam(Team battingTeam) {
        this.battingTeam = battingTeam;
    }

    public Team getBowlingTeam() {
        return bowlingTeam;
    }

    public void setBowlingTeam(Team bowlingTeam) {
        this.bowlingTeam = bowlingTeam;
    }

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public int getNoOfBalls() {
        return noOfBalls;
    }

    public void setNoOfBalls(int noOfBalls) {
        this.noOfBalls = noOfBalls;
    }


    public Game(Team team1, Team team2, int noOfBalls) {
        this.team1 = team1;
        this.team2 = team2;
        this.noOfBalls = noOfBalls;
    }

    public void toss() {
        int randomNumber = generateRandomNumber() % 2;
        if (randomNumber == 0) {
            this.tossWinningTeam = team1;
            team1.setWonToss(true);
        } else {
            this.tossWinningTeam = team2;
            team2.setWonToss(true);
        }
    }

    public int bowl() {
        return generateRandomNumber() % 8;
    }


    public int generateRandomNumber() {
        int randomNumber = (int) (Math.random() * 10);
        return randomNumber;
    }

    public void startFirstInning() {
        this.team1 = simulateBalling(this.team1);
    }

    public void startSecondInning() {
        this.team2 = simulateBalling(team2);
    }

    public Team simulateBalling(Team team) {
        for (int i = 0; i < noOfBalls; i++) {
            int res = bowl();
            int currScore = team.getScore();
            int currWicket = team.getNoOfWicketFell();
            if (res == 7)
                currWicket += 1;
            else
                currScore += res;
            team.setScore(currScore);   // should update team1 object after every ball or  at last
            team.setNoOfWicketFell(currWicket);
            if (currWicket == team.getNoOfPlayers() - 1) {
                break;
            }
        }
        return team;
    }

    public String result() {
        if (team1.getScore() > team2.getScore()) {
            return team1.getName();
        } else if (team1.getScore() < team2.getScore()) {
            return team2.getName();
        }
        return "Draw";
    }

    @Override
    public String toString() {
        return "Game{" +
                "team1=" + team1 +
                ", team2=" + team2 +
                ", noOfBalls=" + noOfBalls +
                ", tossWinningTeam=" + tossWinningTeam +
                ", battingTeam=" + battingTeam +
                ", bowlingTeam=" + bowlingTeam +
                '}';
    }
}
