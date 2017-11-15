package board;

import game.GameState;

import java.util.ArrayList;
import java.util.List;

public class ColumnResolver implements WinResolver {

    public List<Move> resolve(int suggestedPosition, GameState gameState) {
        BoardDimensions dimensions = gameState.getGameBoard().getDimensions();
        List<Move> result = new ArrayList<>();
        int column = suggestedPosition % dimensions.getY();
        for (int i = 0; i < dimensions.getY(); i++) {
            if(column + dimensions.getY() * i < gameState.getBoard().size()){
                result.add(gameState.getBoard().get(column + dimensions.getY() * i));
            }
        }
        return result;
    }
}
