package player;

public class Score {

    private int score;

    public int getValue() {
        return score;
    }

    void addScore(int score) {
            this.score += score;
    }

    @Override
    public String toString() {
        return "score=" + score;
    }
}
