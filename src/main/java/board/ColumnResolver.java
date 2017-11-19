package board;

import game.GameState;
import game.GameSymbol;
import gameHistory.GameProgress;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public boolean resolve(GameProgress gameProgress) {
        BoardDimensions dimensions = gameProgress.getConfiguration().getBoardDimensions();
        List<Move> moves = gameProgress.getMoves();
        GameSymbol symbol = moves.get(moves.size() - 1).getGameSymbol();
        moves = moves.stream().filter(c -> c.getGameSymbol().equals(symbol)).collect(Collectors.toList());
        int counter = 1;
        for (int i = moves.size() - 1; i >= 0; i--) {
            if(counter == gameProgress.getConfiguration().getGameSymbolsToWin()){
                return true;
            }
            if(i - 1 >= 0){
                Move lastMove = moves.get(i);
                Move prevMove = moves.get(i - 1);
                if(isNext(dimensions, lastMove, prevMove) || isPrev(dimensions, lastMove, prevMove)){
                    counter++;
                }
            }
        }
        return false;

    }

    private boolean isPrev(BoardDimensions dimensions, Move lastMove, Move prevMove) {
        return lastMove.getPosition() - dimensions.getX() == prevMove.getPosition();
    }

    private boolean isNext(BoardDimensions dimensions, Move lastMove, Move prevMove) {
        return lastMove.getPosition() + dimensions.getX() == prevMove.getPosition();
    }
}
