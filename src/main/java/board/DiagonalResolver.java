package board;

import game.GameState;

import java.util.ArrayList;
import java.util.List;

public class DiagonalResolver implements WinResolver {

    public List<Move> resolve(int suggestedPosition, GameState gameState) {
        BoardDimensions dimensions = gameState.getGameBoard().getDimensions();
        List<Move> board = new ArrayList<>();

        int row = suggestedPosition / dimensions.getX() + 1;
        int column = suggestedPosition % dimensions.getY() + 1;




        int lastIndex = row * column - 1;

        return board;
    }



//    public List<Move> resolve(int position, GameProgress gameProgress) {
//        List<Move> moves = gameProgress.getMoves();
//
//        GameState gameState = boardBuilder.build(moves);
//
//    }
}
