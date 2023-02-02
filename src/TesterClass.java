import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TesterClass {

    public static void main(String[] args) throws IOException {

        printToConsole("Enter number of balls in an Inning: ");
        int noOfBalls = Integer.parseInt(takeInput());
        printToConsole("Enter number of players in each team: ");
        int noOfPlayers = Integer.parseInt(takeInput());
        Team team1, team2;
        team1 = createTeam(noOfPlayers, 1);
        team2 = createTeam(noOfPlayers, 2);
        System.out.println(team1);
        System.out.println(team2);

        Game game = new Game(team1, team2, noOfBalls);
       // game.toString();
        game.toss();
        Team tossWinningTeam = game.getTossWinningTeam();
        printToConsole(tossWinningTeam.getName() + "won the toss!");
        chooseBatOrBowl(game);
        System.out.println(game);
//        game.startFirstInning();
//
//        game.startSecondInning();
//        System.out.println(game.getTeam1().getNoOfWicketFell());
//        System.out.println(game.getTeam2().getNoOfWicketFell());
//        System.out.println(game.result());


    }

    public static String takeInput() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        return input.readLine();
    }

    public static void printToConsole(String text) {
        System.out.println(text);
    }

    public static Game chooseBatOrBowl(Game game) throws IOException {
        printToConsole("What you would like to do first: 1. Batting\n 2. Bowling ");
        int option = Integer.parseInt(takeInput());
        if ((option == 1 && game.getTeam1().getWonToss()) ||
                option == 2 && game.getTeam2().getWonToss()) {
            game.setBattingTeam(game.getTeam1());
            game.setBowlingTeam(game.getTeam2());
        } else {
            game.setBowlingTeam(game.getTeam1());
            game.setBattingTeam(game.getTeam2());
        }
        return game;


    }

    public static Team createTeam(int noOfPlayers, int index) throws IOException {
//        System.out.println("Enter name of team " + index + ": ");
//        String teamName1 = takeInput();
        Player[] playersOfTeam1 = new Player[noOfPlayers];
        for (int i = 0; i < noOfPlayers; i++) {
            System.out.println("Enter name of Player " + (i + 1) + ": ");
            playersOfTeam1[i] = new Player.Builder().setName("P" + (i + 1)).build();
        }
        Team team = new Team.Builder()
                .setName("T" + (index))
                .setNoOfPlayers(noOfPlayers)
                .setPlayers(playersOfTeam1)
                .build();
        return team;
    }

}
