package game;

import UI.BoardPrinter;
import player.Player;

public class Move {

    private int position;

    public Move(int position){
        this.position = position;
    }

    public GameState doMove(GameState gameState, Player player){
        gameState.addElement(position, player.getGameSymbol());

        //todo each call creates new boardprinter?
        BoardPrinter boardPrinter = new BoardPrinter(gameState);
        System.out.println(boardPrinter.print());
        return gameState;
    }
}
