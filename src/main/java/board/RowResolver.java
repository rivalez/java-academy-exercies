package board;

import game.GameState;

import java.util.List;

public class RowResolver {

    public List<Field> resolve(int suggestedPosition, GameState gameState) {
        BoardDimensions dimensions = gameState.getGameField().getDimensions();
        int row = suggestedPosition / dimensions.getX();
        return gameState.getBoard().subList(row, row + dimensions.getX());
    }
}
