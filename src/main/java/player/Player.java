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

    public void addScore(int i){
        score.addScore(i);
    }

    @Override
    public String toString() {
        return String.format("%s  -  %s  -  %s", this.name, this.gameSymbol.name(), this.score.toString());
    }

    public Score getScore() {
        return score;
    }
}
