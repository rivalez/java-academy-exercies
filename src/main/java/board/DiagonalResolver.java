package board;

import game.GameState;

import java.util.ArrayList;
import java.util.List;

public class DiagonalResolver {

    public List<Field> resolve(int suggestedPosition, GameState gameState) {
        BoardDimensions dimensions = gameState.getGameField().getDimensions();
        List<Field> board = new ArrayList<>();
        for (int i = 0; i < dimensions.getY(); i++) {
            if(suggestedPosition + dimensions.getY() + 1 < gameState.getBoard().size()){
                board.add(gameState.getBoard().get(suggestedPosition + dimensions.getY() + 1));
            } else if(suggestedPosition - dimensions.getY() - 1 < gameState.getBoard().size()) {
                board.add(gameState.getBoard().get(suggestedPosition - dimensions.getY() - 1));
            }
        }
        return board;
    }
}
