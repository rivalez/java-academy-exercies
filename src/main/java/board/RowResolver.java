package board;

import gameHistory.GameProgress;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RowResolver implements WinResolver {

    @Override
    public boolean resolve(GameProgress gameProgress) {
        BoardDimensions dimensions = gameProgress.getConfiguration().getBoardDimensions();
        Move lastMove = gameProgress.getLast();
        int row = lastMove.getPosition() / dimensions.getX();
        List<Move> moves = gameProgress.getMoves().stream()
                .filter(getSymbolPredicate(gameProgress))
                .filter(m -> m.getPosition() / dimensions.getX() == row)
                .sorted()
                .collect(Collectors.toList());

        Set<Move> movesToWin = new HashSet<>();
        for (int i = 0; i < moves.size() - 1; i++) {
            Move prev = moves.get(i);
            Move next = moves.get(i + 1);
            if(Math.abs(next.getPosition() - prev.getPosition()) == 1){
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
