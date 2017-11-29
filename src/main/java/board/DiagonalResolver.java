package board;

import game.GameSymbol;
import gamehistory.GameProgress;

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
        for (int c = 0; c < moves.size() - 1; c++) {
            Move move = moves.get(c);
            Move nextMove = moves.get(c + 1);
            if(move.getPosition() + dimensions.getX() + 1 == nextMove.getPosition()){
                counter++;
                if (move.getPosition() % dimensions.getX() == dimensions.getX() - 1) {
                    break;
                }
            }
            if(counter == gameProgress.getConfiguration().getGameSymbolsToWin()){
                result = true;
            }
        }
        return result;
    }
}
