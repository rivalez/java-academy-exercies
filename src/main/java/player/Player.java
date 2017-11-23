package player;

import game.GameSymbol;

public class Player {

    private GameSymbol gameSymbol;
    private String name;
    private Score score;

    public Player(GameSymbol gameSymbol, String name) {
        this.gameSymbol = gameSymbol;
        this.score = new Score();
        this.name = name;
    }

    public GameSymbol getGameSymbol() {
        return gameSymbol;
    }

    public Score getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "name " + name + " with symbol " + gameSymbol + " has " + score;
    }
}
