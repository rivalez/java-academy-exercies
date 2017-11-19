package board;

import game.GameState;
import gameHistory.GameProgress;

import java.util.List;

public class RowResolver implements WinResolver {

    public List<Move> resolve(int suggestedPosition, GameState gameState) {
        BoardDimensions dimensions = gameState.getGameBoard().getDimensions();
        int row = suggestedPosition / dimensions.getX();
        int fromIndex = row * dimensions.getX();
        return gameState.getBoard().subList(fromIndex, fromIndex + dimensions.getX());
    }

    @Override
    public boolean resolve(GameProgress gameProgress) {
        return false;
    }
}
