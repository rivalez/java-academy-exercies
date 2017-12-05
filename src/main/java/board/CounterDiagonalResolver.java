package board;

import game.GameSymbol;
import gamehistory.GameProgress;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CounterDiagonalResolver implements WinResolver {

    @Override
    public boolean resolve(GameProgress gameProgress) {
        BoardDimensions dimensions = gameProgress.getConfiguration().getBoardDimensions();
        List<Move> moves = gameProgress.getMoves();

        GameSymbol symbol = moves.get(moves.size() - 1).getGameSymbol();
        moves = moves.stream()
                .filter(c -> c.getGameSymbol().equals(symbol))
                .filter(m -> m.getPosition() != 0)
                .collect(Collectors.toList());
        int counter = 1;
        boolean result = false;
        Collections.sort(moves);
        counter = validate(dimensions, moves, counter);
        if(counter == gameProgress.getConfiguration().getGameSymbolsToWin()){
            result = true;
        }
        return result;
    }

    private int validate(BoardDimensions dimensions, List<Move> moves, int counter) {
        for (int c = 0; c < moves.size() - 1; c++) {
            Move move = moves.get(c);
            Move nextMove = moves.get(c + 1);
            if(move.getPosition() + dimensions.getX() - 1 == nextMove.getPosition()){
                if (move.getPosition() % dimensions.getX() == 0) break;
                counter++;
            }
        }
        return counter;
    }
}
