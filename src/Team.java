import java.util.Arrays;

public class Team {
    private Player[] players;
    private String name;
    private int score;
    private int noOfWicketFell;
    private int noOfPlayers = 11;

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

    private Team(Builder teamBuilder) {
        this.name = teamBuilder.name;
        this.noOfPlayers = teamBuilder.noOfPlayers;
        this.noOfWicketFell = teamBuilder.noOfWicketFell;
        this.score = teamBuilder.score;
        this.players = teamBuilder.players;
    }

    @Override
    public String toString() {
        return "Team{" +
                "players=" + Arrays.toString(players) +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", noOfWicketFell=" + noOfWicketFell +
                ", noOfPlayers=" + noOfPlayers +
                '}';
    }


    public static class Builder {

        private Player[] players;
        private String name;
        private int score;
        private int noOfWicketFell;
        private int noOfPlayers = 11;

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

        public Team build() {
            return new Team(this);
        }

    }

}
