package board;

import game.GameState;

import java.util.ArrayList;
import java.util.List;

public class ColumnResolver {

    public List<Field> resolve(int suggestedPosition, GameState gameState) {
        BoardDimensions dimensions = gameState.getGameField().getDimensions();
        List<Field> result = new ArrayList<>();
        int i1 = suggestedPosition % dimensions.getY();
        for (int i = 0; i < dimensions.getY(); i++) {
            if(i1 + dimensions.getY() * i < gameState.getBoard().size()){
                result.add(gameState.getBoard().get(i1 + dimensions.getY() * i));
            }
        }
        return result;
    }
}
