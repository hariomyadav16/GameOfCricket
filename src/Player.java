public class Player {
    private String name;
    private int runs;
    private int totalWicketsTaken;
    private int totalFours;
    private int totalSixes;

    private int skillLevel;

    public int getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(int skillLevel) {
        this.skillLevel = skillLevel;
    }

    public int getTotalFours() {
        return totalFours;
    }

    public void setTotalFours(int totalFours) {
        this.totalFours = totalFours;
    }

    public int getTotalSixes() {
        return totalSixes;
    }

    public void setTotalSixes(int totalSixes) {
        this.totalSixes = totalSixes;
    }

    public Player() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public int getTotalWicketsTaken() {
        return totalWicketsTaken;
    }

    public void setTotalWicketsTaken(int totalWicketsTaken) {
        this.totalWicketsTaken = totalWicketsTaken;
    }

    //    private Player(Builder playerBuilder) {
//        this.name = playerBuilder.name;
//        this.runs = playerBuilder.totalRunsScored;
//        this.totalWicketsTaken = playerBuilder.totalWicketsTaken;
//    }
//    public static class Builder {
//
//        private String name;
//        private int totalRunsScored;
//        private int totalWicketsTaken;
//
//        public Builder setName(String name) {
//            this.name = name;
//            return this;
//        }
//
//
//        public Builder setTotalRunsScored(int totalRunsScored) {
//            this.totalRunsScored = totalRunsScored;
//            return this;
//        }
//
//        public Builder setTotalWicketsTaken(int totalWicketsTaken) {
//            this.totalWicketsTaken = totalWicketsTaken;
//            return this;
//        }
//
//        public Player build() {
//            return new Player(this);
//        }
//
//    }

}
