package game;

import player.Player;

public class Mover {

    private int position;

    public Mover(int position){
        this.position = position;
    }

    public GameState doMove(GameState gameState, Player player){
        gameState.addElement(position, player.getGameSymbol());
        return gameState;
    }
}
