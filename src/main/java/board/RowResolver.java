package board;

import game.GameSymbol;
import gameHistory.GameProgress;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RowResolver implements WinResolver {

    @Override
    public boolean resolve(GameProgress gameProgress) {
        BoardDimensions dimensions = gameProgress.getConfiguration().getBoardDimensions();
        List<Move> moves = gameProgress.getMoves();

        GameSymbol symbol = moves.get(moves.size() - 1).getGameSymbol();
        moves = moves.stream().filter(c -> c.getGameSymbol().equals(symbol)).collect(Collectors.toList());
        int counter = 1;
        Move lastMove = moves.get(moves.size() - 1);
        int row = lastMove.getPosition() / dimensions.getX();
        boolean result = false;
        Collections.sort(moves);
        for (int i = 0; i < moves.size() - 1; i++) {
            Move move = moves.get(i);
            if(move.getPosition() / dimensions.getX() == row
                    && Math.abs(moves.get(i + 1).getPosition() - move.getPosition()) == 1) {
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
