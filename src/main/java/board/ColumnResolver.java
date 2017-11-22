package board;

import gameHistory.GameProgress;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ColumnResolver implements WinResolver {

    @Override
    public boolean resolve(GameProgress gameProgress) {
        List<Move> moves = gameProgress.getMoves().stream()
                .filter(getSymbolPredicate(gameProgress))
                .sorted()
                .collect(Collectors.toList());
        Set<Move> correctMoves = new HashSet<>();
        for(int i = 0 ; i < moves.size(); i++){
            for (Move move : moves) {
                if (Math.abs(moves.get(i).getPosition() - move.getPosition()) == gameProgress.getConfiguration().getBoardDimensions().getX()) {
                    correctMoves.add(move);
                }
            }
        }
        return correctMoves.size() >= gameProgress.getConfiguration().getGameSymbolsToWin();
    }

    private Predicate<Move> getSymbolPredicate(GameProgress gameProgress) {
        return m -> m.getGameSymbol() == gameProgress.getMoves().get(gameProgress.getMoves().size() - 1).getGameSymbol();
    }
}
