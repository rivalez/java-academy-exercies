package board;

import game.GameState;

import java.util.ArrayList;
import java.util.List;

public class DiagonalResolver implements WinResolver {

    public List<Move> resolve(int suggestedPosition, GameState gameState) {
        BoardDimensions dimensions = gameState.getGameBoard().getDimensions();
        List<Move> board = new ArrayList<>();

        int row = suggestedPosition / dimensions.getX();
        int column = suggestedPosition % dimensions.getY();

        board.add(gameState.getBoard().get(column));
        int f = dimensions.getX() + column + 1;
        for (int i = 0; i < gameState.getBoard().size(); i++) {
            if(f < gameState.getBoard().size()){
                if(!gameState.getBoard().get(f).isEmpty()){
                    board.add(gameState.getBoard().get(f));
                }
            } else {
                break;
            }
            f += dimensions.getX() + 1;
        }

        return board;
    }
}
