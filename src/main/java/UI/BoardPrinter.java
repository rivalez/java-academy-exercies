package UI;

import board.Move;
import board.BoardDimensions;
import game.GameState;

import java.util.List;

public class BoardPrinter {

    private final GameState gameState;

    public BoardPrinter(GameState gameState) {
        this.gameState = gameState;
    }

    //todo stringbuilder 1 for co dimenstion.getY() % + "\n"
    public String print() {
        StringBuilder stringBuilder = new StringBuilder();
        List<Move> board = gameState.getBoard();
        BoardDimensions dimensions = gameState.getGameBoard().getDimensions();
        int counter = 0;
        for(int i = 0 ; i < dimensions.getX(); i++){
            for(int j = 0; j < dimensions.getY(); j++){
                stringBuilder.append(board.get(counter++)).append(" ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
