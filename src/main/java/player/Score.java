package player;

public class Score {

    private int score;

    int getValue() {
        return score;
    }

    public void addScore(int score) {
            this.score += score;
    }

    @Override
    public String toString() {
        return "score=" + score;
    }
}
