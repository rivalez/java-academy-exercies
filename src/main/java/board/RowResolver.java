package board;

import game.GameState;

import java.util.List;

public class RowResolver implements WinResolver {

    public List<Move> resolve(int suggestedPosition, GameState gameState) {
        BoardDimensions dimensions = gameState.getGameBoard().getDimensions();
        int row = suggestedPosition / dimensions.getX();
        int fromIndex = row * dimensions.getX();
        return gameState.getBoard().subList(fromIndex, fromIndex + dimensions.getX());
    }
}
