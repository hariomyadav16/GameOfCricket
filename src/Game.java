import java.util.ArrayList;
import java.util.Formatter;

import static java.lang.Thread.*;


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
        this.team1 = simulateBalling(false);
    }

    public void changeInnings() {
        Team temp = this.battingTeam;
        this.battingTeam = this.bowlingTeam;
        this.bowlingTeam = temp;
    }

    public void startSecondInning() {
        this.team2 = simulateBalling(true);
    }

    public Team simulateBalling(Boolean isSecondInning) {
        int currBatsmanIndex = 0;
        int currBowlerIndex = 0;
        int currRun = 0;
        for (int currBall = 1; currBall <= noOfBalls; currBall++) {
            int res = bowl();
            int currWicket = battingTeam.getNoOfWicketFell();
            if (res == 7) {
                currWicket++;
                int bowlingTeamBatsmanIndex = bowlingTeam.getNoOfPlayers() - (bowlingTeam.getNoOfPlayers() - currBowlerIndex);
                if (currBowlerIndex < bowlingTeam.getNoOfBowler()) {
                    onWicket(currBowlerIndex, true);
                } else if (bowlingTeamBatsmanIndex < bowlingTeam.getNoOfBatsman()) {
                    onWicket(bowlingTeamBatsmanIndex, false);
                } else {
                    currBowlerIndex = 0;
                }
                if (currWicket == battingTeam.getNoOfPlayers()) {  // last batsman plays
                    break;
                }
                currBatsmanIndex++;
            } else {
                currRun += res;
                int battingTeamBowlerIndex = battingTeam.getNoOfBowler() - (battingTeam.getNoOfPlayers() - currBatsmanIndex);
                if (currBatsmanIndex < battingTeam.getNoOfBatsman()) {
                    onRun(res, currBatsmanIndex, true);
                } else if (battingTeamBowlerIndex < battingTeam.getNoOfBowler()) {
                    onRun(res, battingTeamBowlerIndex, false);
                } else {
                    break;
                }
                if (isSecondInning && currRun > bowlingTeam.getScore())
                    break;
                if (currBall % 6 == 0)
                    currBowlerIndex++;

            }
            // should update team1 object after every ball or  at last
            try {
                sleep(600);
            } catch (InterruptedException except) {
                currentThread().interrupt();
            }
        }
        Utils.printToConsole("\n");
        return battingTeam;
    }

    public void onWicket(int currIndex, Boolean isBowlerAvailable) {

        if (isBowlerAvailable) {
            updateBowlerStats(bowlingTeam.getBowlerArrayList(), currIndex);
        } else {
            updateBowlerStats(bowlingTeam.getBatsmanArrayList(), currIndex);
        }

        int currWicket = battingTeam.getNoOfWicketFell();
        Utils.printToConsole("W ");
        currWicket += 1;
        battingTeam.setNoOfWicketFell(currWicket);
    }

    public void onRun(int run, int currIndex, Boolean isBatsmanAvailable) {
        Utils.printToConsole(run + " ");
        if (isBatsmanAvailable) {
            updateBatsmanStats(battingTeam.getBatsmanArrayList(), currIndex, run);
        } else {
            updateBatsmanStats(battingTeam.getBowlerArrayList(), currIndex, run);
        }
        battingTeam.setScore(battingTeam.getScore() + run);
    }


    public void updateBatsmanStats(ArrayList<Player> list, int currIndex, int run) { //TODO: ADD RUN TO BOWLER STATS TOO, ECONOMY
        Player currPlayer = list.get(currIndex);
        list.get(currIndex).setRuns(currPlayer.getRuns() + run);
        if (run == 4) {
            list.get(currIndex).setTotalFours(currPlayer.getTotalFours() + 1);
        } else if (run == 6) {
            list.get(currIndex).setTotalSixes(currPlayer.getTotalSixes() + 1);
        }

    }

    public void updateBowlerStats(ArrayList<Player> list, int currIndex)  // TODO: ADD NO OF OVERS THROWN
    {
        Player currPlayer = list.get(currIndex);
        list.get(currIndex).setTotalWicketsTaken(currPlayer.getTotalWicketsTaken() + 1);
    }

//    public String result() {
//        if (team1.getScore() > team2.getScore()) {
//            return team1.getName();
//        } else if (team1.getScore() < team2.getScore()) {
//            return team2.getName();
//        }
//        return "Draw";
//    }

    public void gameResult() {
        int wicketDiff = 0, runDiff;
        if (battingTeam.getScore() > bowlingTeam.getScore()) {
            wicketDiff = battingTeam.getNoOfPlayers() - battingTeam.getNoOfWicketFell();
            runDiff = battingTeam.getScore() - bowlingTeam.getScore();
            printWinningMsg(wicketDiff, runDiff, true);

        } else if (battingTeam.getScore() < bowlingTeam.getScore()) {
            runDiff = bowlingTeam.getScore() - battingTeam.getScore();
            printWinningMsg(wicketDiff, runDiff, false);
        } else {
            Utils.printToConsole("The match is Drawn!");
        }
    }

    public void printWinningMsg(int wicketDiff, int runDiff, boolean isSecondInningPlayingTeamWon) {
        if (isSecondInningPlayingTeamWon) {
            if (wicketDiff == 0) {
                wonByRunText(runDiff);
            } else {
                wonByWicketText(wicketDiff);
            }
        } else {
            wonByRunText(runDiff);
        }
    }

    public void wonByWicketText(int wicketDiff) {
        if (wicketDiff == 1) {
            Utils.printToConsole("Team " + battingTeam.getName() + " won the match by " + wicketDiff + " wicket!\n");
        } else {
            Utils.printToConsole("Team " + battingTeam.getName() + " won the match by " + wicketDiff + " wickets!\n");
        }
    }

    public void wonByRunText(int runDiff) {
        if (runDiff == 1) {
            Utils.printToConsole("Team " + battingTeam.getName() + " won the match by " + runDiff + " run!\n");
        } else {
            Utils.printToConsole("Team " + battingTeam.getName() + " won the match by " + runDiff + " runs!\n");
        }
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

    public void showScorecard(Team team) {
        Formatter formatter = new Formatter();
        formatter.format("TeamName: " + team.getName() + "\n");
        formatter.format("%15s %15s %15s %15s %15s\n", "Players", "Runs", "Fours", "Sixes", "Wicket");
        team.getBatsmanArrayList().forEach(player -> {
            formatter.format("%10s %19s %15s %15s %15s\n", player.getName(), player.getRuns(), player.getTotalFours(), player.getTotalSixes(), player.getTotalWicketsTaken());
        });
        team.getBowlerArrayList().forEach(player -> {
            formatter.format("%10s %19s %15s %15s %15s\n", player.getName(), player.getRuns(), player.getTotalFours(), player.getTotalSixes(), player.getTotalWicketsTaken());
        });
        formatter.format("Score: " + team.getScore() + "\\" + team.getNoOfWicketFell() + "\n");

        System.out.println(formatter);

    }
}
