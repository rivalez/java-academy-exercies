package UI;

import board.BoardDimensions;
import board.Move;
import game.GameState;

import java.util.List;

public class BoardPrinter {

    //todo stringbuilder 1 for co dimenstion.getY() % + "\n"
    public String print(GameState gameState) {
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
