import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TesterClass {

    public static void main(String[] args) throws IOException {

        Utils.printToConsole("Enter number of balls in an Inning: ");
        int noOfBalls, noOfPlayers;
        noOfBalls = convertToInt(takeInput());

        Utils.printToConsole("Enter number of players in each team: ");
        noOfPlayers = convertToInt(takeInput());

        Team team1, team2;
        team1 = createTeam(noOfPlayers, 1);
        team2 = createTeam(noOfPlayers, 2);

        Game game = new Game(team1, team2, noOfBalls);
        game.toss();

        Team tossWinningTeam = game.getTossWinningTeam();
        Utils.printToConsole(tossWinningTeam.getName() + " won the toss!\n");

        chooseBatOrBowl(game);

        Utils.printToConsole("Starting First Inning, " + "Team " + game.getBattingTeam().getName() + " is batting\n");
        game.startFirstInning();
        game.changeInnings();
        Utils.printToConsole("Starting Second Inning, " + "Team " + game.getBattingTeam().getName() + " is batting\n");
        game.startSecondInning();

        game.showScorecard(game.getTeam1());
        game.showScorecard(game.getTeam2());

//        if (game.result().equals("Draw"))
//            printToConsole("The match is drawn!\n");
//        else
//            printToConsole("Team " + game.result() + " won the match!\n");
        game.gameResult();


    }

    public static String takeInput() throws IOException {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            return input.readLine();
        } catch (IOException exception) {
            System.out.println("Please enter valid value!");
            takeInput();
        }
        return "";
    }

//    public static void Utils.printToConsole(String text) {
//        System.out.print(text);
//    }


    public static int convertToInt(String text) throws IOException {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException exception) {
            System.out.println("Please enter an Integer value, Try Again!");
            return convertToInt(takeInput());
        }

    }

    public static void chooseBatOrBowl(Game game) throws IOException {
        Utils.printToConsole("What you would like to do first:\n1. Batting\n2. Bowling \n");
        int option = convertToInt(takeInput());
        if ((option == 1 && game.getTeam1().getWonToss()) ||
                option == 2 && game.getTeam2().getWonToss()) {
            game.setBattingTeam(game.getTeam1());
            game.setBowlingTeam(game.getTeam2());

        } else {
            game.setBowlingTeam(game.getTeam1());
            game.setBattingTeam(game.getTeam2());
        }


    }

    public static Team createTeam(int noOfPlayers, int index) throws IOException {
        Utils.printToConsole("Enter name of team " + index + ": ");
        String teamName = takeInput();
        Player[] playersOfTeam1 = new Player[noOfPlayers];
        ArrayList<Player> batsmanArrayList = new ArrayList<>();
        ArrayList<Player> bowlerArrayList = new ArrayList<>();
        for (int i = 0; i < noOfPlayers; i++) {
            Utils.printToConsole("Enter name of Player " + (i + 1) + ": ");
            String playerName = takeInput();
            if (knowPlayerSkill() == 1) {
                playersOfTeam1[i] = new Batsman(playerName);
                batsmanArrayList.add(new Batsman(playerName));

                // batsmanArrayList.get(i).setName("P" + (i+1));
                // playersOfTeam1[i].setName("P" + (i+1));
            } else {
                playersOfTeam1[i] = new Bowler(playerName);

                bowlerArrayList.add(new Bowler(playerName));
//                playersOfTeam1[i] = new Bowler();
//                playersOfTeam1[i].setName("P" + (i+1));

            }
            // playersOfTeam1[i] = new Player.Builder().setName("P" + (i + 1)).build();
        }
        return new Team.Builder()
                .setName(teamName)
                .setNoOfPlayers(noOfPlayers)
                .setPlayers(playersOfTeam1)
                .setBatsmanArrayList(batsmanArrayList)
                .setBowlerArrayList(bowlerArrayList)
                .setNoOfBatsman(batsmanArrayList.size())
                .setNoOfBowler(bowlerArrayList.size())
                .build();
    }

    public static int knowPlayerSkill() throws IOException {
        Utils.printToConsole("Choose players skill:\n 1. Batsman\n 2. Bowler\n");
        return convertToInt(takeInput());
    }

}
