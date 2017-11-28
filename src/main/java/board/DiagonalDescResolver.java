package board;

import gameHistory.GameProgress;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DiagonalDescResolver implements WinResolver {

    @Override
    public boolean resolve(GameProgress gameProgress) {
        BoardDimensions dimensions = gameProgress.getConfiguration().getBoardDimensions();
        Move last = gameProgress.getLast();
        int boardWidth = dimensions.getX();
        int column = last.getPosition() % boardWidth;
        int row = last.getPosition() / dimensions.getX();
        Set<Move> movesToWin = new HashSet<>();
        movesToWin.add(last);

        List<Move> moves = gameProgress.getMoves().stream()
                .filter(getSymbolPredicate(gameProgress))
                .filter(m -> m.getPosition() % boardWidth != column)
                .filter(m -> m.getPosition() / dimensions.getX() != row)
                .sorted()
                .collect(Collectors.toList());

        for (int c = 1; c <= moves.size(); c++) {
            Move prev = moves.get(c - 1);
            if(Math.abs(last.getPosition() + (dimensions.getX() + 1) * c) == prev.getPosition()){
                movesToWin.add(prev);
            }
        }

        if(movesToWin.size() < gameProgress.getConfiguration().getGameSymbolsToWin()){
            movesToWin.clear();
            for (int c = 0; c < moves.size() - 1; c++) {
                Move prev = moves.get(c);
                Move next = moves.get(c + 1);
                if(Math.abs(prev.getPosition() + dimensions.getX() - 1) == next.getPosition()){
                    movesToWin.add(prev);
                    movesToWin.add(next);
                }
            }
        }

        return movesToWin.size() >= gameProgress.getConfiguration().getGameSymbolsToWin();
    }

    private Predicate<Move> getSymbolPredicate(GameProgress gameProgress) {
        return m -> m.getGameSymbol() == gameProgress.getMoves().get(gameProgress.getMoves().size() - 1).getGameSymbol();
    }
}
