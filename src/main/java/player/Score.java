package player;

public class Score {

    private int points;

    public int getValue() {
        return points;
    }

    void addScore(int score) {
            this.points += score;
    }

    @Override
    public String toString() {
        return "points=" + points;
    }
}
