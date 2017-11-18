package player;

import game.GameSymbol;

public class Player {

    private GameSymbol gameSymbol;
    private String name;
    private Score score;

    public Player(GameSymbol gameSymbol) {
        this.gameSymbol = gameSymbol;
        this.score = new Score();
    }

    public GameSymbol getGameSymbol() {
        return gameSymbol;
    }

    public Score getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Player{" +
                "gameSymbol=" + gameSymbol +
                ", name='" + name;
    }
}
