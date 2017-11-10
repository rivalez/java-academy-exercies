package game;

import UI.BoardPrinter;
import player.Player;

import java.util.Scanner;

public class Move {

    public GameState doMove(GameState gameState, Player player){
        Scanner scanner = new Scanner(System.in);
        new Communicate("please type number in which you want to place your symbol ").getMessage();
        int position = scanner.nextInt();

        gameState.addElement(position, player.getGameSymbol());
        BoardPrinter boardPrinter = new BoardPrinter(gameState);
        System.out.println(boardPrinter.print());
        return gameState;
    }
}
