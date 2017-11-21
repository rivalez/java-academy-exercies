package board;

import game.GameSymbol;
import gameHistory.GameProgress;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ColumnResolver implements WinResolver {

    @Override
    public boolean resolve(GameProgress gameProgress) {
        BoardDimensions dimensions = gameProgress.getConfiguration().getBoardDimensions();
        List<Move> moves = gameProgress.getMoves();
        int counter = 1;
        Move lastMove = moves.get(moves.size() - 1);
        int column = lastMove.getPosition() % dimensions.getX();
        GameSymbol symbol = moves.get(moves.size() - 1).getGameSymbol();
        moves = moves.stream()
                .filter(c -> c.getGameSymbol().equals(symbol))
                .filter(c -> c.getPosition() % dimensions.getX() == column)
                .sorted()
                .collect(Collectors.toList());

        boolean result = false;
        for (int i = 0; i < moves.size() - 1; i++) {
            Move move = moves.get(i);
            if(Math.abs(moves.get(i + 1).getPosition() - move.getPosition()) == dimensions.getX()){
                counter++;
            } else {
                counter = 1;
            }
            if(counter == gameProgress.getConfiguration().getGameSymbolsToWin()){
                result = true;
            }
        }
        return result;
    }
}
