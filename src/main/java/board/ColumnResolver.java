package board;

import gamehistory.GameProgress;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ColumnResolver implements WinResolver {

    @Override
    public boolean resolve(GameProgress gameProgress) {
        Move last = gameProgress.getLast();
        int boardWidth = gameProgress.getConfiguration().getBoardDimensions().getX();
        int column = last.getPosition() % boardWidth;
        List<Move> moves = gameProgress.getMoves().stream()
                .filter(getSymbolPredicate(gameProgress))
                .filter(m -> m.getPosition() % boardWidth == column)
                .sorted()
                .collect(Collectors.toList());

        Set<Move> movesToWin = new HashSet<>();
        for (int i = 0; i < moves.size() - 1; i++) {
            Move prev = moves.get(i);
            Move next = moves.get(i + 1);
            if(Math.abs(next.getPosition() - prev.getPosition()) == boardWidth){
                movesToWin.add(prev);
                movesToWin.add(next);
            }
        }

        return movesToWin.size() >= gameProgress.getConfiguration().getGameSymbolsToWin();
    }

    private Predicate<Move> getSymbolPredicate(GameProgress gameProgress) {
        return m -> m.getGameSymbol() == gameProgress.getMoves().get(gameProgress.getMoves().size() - 1).getGameSymbol();
    }
}
