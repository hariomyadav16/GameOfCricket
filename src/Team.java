import java.util.ArrayList;
import java.util.Arrays;

public class Team {
    private Player[] players;

    private ArrayList<Player> batsmanArrayList;

    private ArrayList<Player> bowlerArrayList;
    private String name;
    private int score;
    private int noOfWicketFell;
    private int noOfPlayers = 11;
    private int noOfBatsman;
    private int noOfBowler;

    public int getNoOfBatsman() {
        return noOfBatsman;
    }

    public void setNoOfBatsman(int noOfBatsman) {
        this.noOfBatsman = noOfBatsman;
    }

    public int getNoOfBowler() {
        return noOfBowler;
    }

    public void setNoOfBowler(int noOfBowler) {
        this.noOfBowler = noOfBowler;
    }

    private Boolean wonToss = false;

    public Team() {

    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setNoOfWicketFell(int noOfWicketFell) {
        this.noOfWicketFell = noOfWicketFell;
    }

    public Boolean getWonToss() {
        return wonToss;
    }

    public void setWonToss(Boolean wonToss) {
        this.wonToss = wonToss;
    }

    public Team(Player[] players, String name, int score, int noOfWicketFell, int noOfPlayers) {
        this.players = players;
        this.name = name;
        this.score = score;
        this.noOfWicketFell = noOfWicketFell;
        this.noOfPlayers = noOfPlayers;
    }

//    public Player[] initializePlayers(int totalPlayer) {
//        this.players = new Player[totalPlayer + 1];
//        for (int index = 0; index < totalPlayer; index++)
//            this.players[index] = new Player.Builder().setName("Player_" + (index + 1)).build();
//        return this.players;
//    }

    public Player[] getPlayers() {
        return players;
    }
    public String getName() {
        return name;
    }
    public int getScore() {
        return score;
    }

    public int getNoOfWicketFell() {
        return noOfWicketFell;
    }
    public int getNoOfPlayers() {
        return noOfPlayers;
    }

    public ArrayList<Player> getBatsmanArrayList() {
        return batsmanArrayList;
    }

    public void setBatsmanArrayList(ArrayList<Player> batsmanArrayList) {
        this.batsmanArrayList = batsmanArrayList;
    }

    public ArrayList<Player> getBowlerArrayList() {
        return bowlerArrayList;
    }

    public void setBowlerArrayList(ArrayList<Player> bowlerArrayList) {
        this.bowlerArrayList = bowlerArrayList;
    }

    private Team(Builder teamBuilder) {
        this.name = teamBuilder.name;
        this.noOfPlayers = teamBuilder.noOfPlayers;
        this.noOfWicketFell = teamBuilder.noOfWicketFell;
        this.score = teamBuilder.score;
        this.players = teamBuilder.players;
        this.batsmanArrayList = teamBuilder.batsmanArrayList;
        this.bowlerArrayList = teamBuilder.bowlerArrayList;
        this.noOfBatsman = teamBuilder.noOfBatsman;
        this.noOfBowler = teamBuilder.noOfBowler;
    }

    @Override
    public String toString() {
        return "Team{" +
                "players=" + Arrays.toString(players) +
                ", batsmanArrayList=" + batsmanArrayList +
                ", bowlerArrayList=" + bowlerArrayList +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", noOfWicketFell=" + noOfWicketFell +
                ", noOfPlayers=" + noOfPlayers +
                ", noOfBatsman=" + noOfBatsman +
                ", noOfBowler=" + noOfBowler +
                ", wonToss=" + wonToss +
                '}';
    }

    public static class Builder {

        private Player[] players;
        private String name;
        private int score;
        private int noOfWicketFell;
        private int noOfPlayers = 11;
        private ArrayList<Player> batsmanArrayList;

        private ArrayList<Player> bowlerArrayList;

        private int noOfBatsman;
        private int noOfBowler;

        public Builder setPlayers(Player[] players) {
            this.players = players;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setScore(int score) {
            this.score = score;
            return this;
        }

        public Builder setNoOfWicketFell(int noOfWicketFell) {
            this.noOfWicketFell = noOfWicketFell;
            return this;
        }

        public Builder setNoOfPlayers(int noOfPlayers) {
            this.noOfPlayers = noOfPlayers;
            return this;
        }


        public Builder setBatsmanArrayList(ArrayList<Player> batsmanArrayList) {
            this.batsmanArrayList = batsmanArrayList;
            return this;
        }

        public Builder setBowlerArrayList(ArrayList<Player> bowlerArrayList) {
            this.bowlerArrayList = bowlerArrayList;
            return this;
        }

        public Builder setNoOfBatsman(int noOfBatsman) {
            this.noOfBatsman = noOfBatsman;
            return this;

        }

        public Builder setNoOfBowler(int noOfBowler) {
            this.noOfBowler = noOfBowler;
            return this;
        }


        public Team build() {
            return new Team(this);
        }

    }

}
