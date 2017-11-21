package board;

import game.GameSymbol;
import gameHistory.GameProgress;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DiagonalResolver implements WinResolver {

    @Override
    public boolean resolve(GameProgress gameProgress) {
        BoardDimensions dimensions = gameProgress.getConfiguration().getBoardDimensions();
        List<Move> moves = gameProgress.getMoves();

        GameSymbol symbol = moves.get(moves.size() - 1).getGameSymbol();
        moves = moves.stream()
                .filter(c -> c.getGameSymbol().equals(symbol))
                .collect(Collectors.toList());
        int counter = 1;
        boolean result = false;
        Collections.sort(moves);
        for (int i = 0; i < moves.size() - 1; i++) {
            Move move = moves.get(i);
            Move nextMove = moves.get(i + 1);
            if(move.getPosition() + dimensions.getX() + 1 == nextMove.getPosition()){
                counter++;
            } else {
                counter = 0;
            }
            if(counter == gameProgress.getConfiguration().getGameSymbolsToWin()){
                result = true;
            }
        }
        return result;
    }
}
