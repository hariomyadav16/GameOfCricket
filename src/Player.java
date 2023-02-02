public class Player {
    enum skillType {batsman, bowler, all_rounder}

    ;
    private String name;
    private skillType skill;
    private int totalRunsScored;
    private int totalWicketsTaken;

    public Player() {
        this.skill = skillType.batsman;
    }

    private Player(Builder playerBuilder) {
        this.name = playerBuilder.name;
        this.skill = playerBuilder.skill;
        this.totalRunsScored = playerBuilder.totalRunsScored;
        this.totalWicketsTaken = playerBuilder.totalWicketsTaken;
    }

    public String getName() {
        return name;
    }

    public skillType getSkill() {
        return skill;
    }

    public int getTotalRunsScored() {
        return totalRunsScored;
    }

    public int getTotalWicketsTaken() {
        return totalWicketsTaken;
    }


    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", skill=" + skill +
                ", totalRuns=" + totalRunsScored +
                ", totalWickets=" + totalWicketsTaken +
                '}';
    }

    public static class Builder {

        private String name;
        private Player.skillType skill;
        private int totalRunsScored;
        private int totalWicketsTaken;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSkill(Player.skillType skill) {
            this.skill = skill;
            return this;
        }

        public Builder setTotalRunsScored(int totalRunsScored) {
            this.totalRunsScored = totalRunsScored;
            return this;
        }

        public Builder setTotalWicketsTaken(int totalWicketsTaken) {
            this.totalWicketsTaken = totalWicketsTaken;
            return this;
        }

        public Player build() {
            return new Player(this);
        }

    }

}
