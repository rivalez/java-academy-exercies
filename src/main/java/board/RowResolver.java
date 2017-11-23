package board;

import game.GameSymbol;
import gameHistory.GameProgress;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RowResolver implements WinResolver {

    @Override
    public boolean resolve(GameProgress gameProgress) {
        BoardDimensions dimensions = gameProgress.getConfiguration().getBoardDimensions();
        List<Move> moves = gameProgress.getMoves();

        Move lastMove = moves.get(moves.size() - 1);
        int row = lastMove.getPosition() / dimensions.getX();
        GameSymbol symbol = moves.get(moves.size() - 1).getGameSymbol();
        moves = moves.stream()
                .filter(m -> m.getGameSymbol().equals(symbol))
                .filter(m -> m.getPosition() / dimensions.getX() == row)
                .sorted()
                .collect(Collectors.toList());

        Set<Move> correctMoves = new HashSet<>();
        for (int i = 0; i < moves.size(); i++) {
            for (int j = 0; j < moves.size() - 1; j++) {
                if(Math.abs(moves.get(i).getPosition() - moves.get(j + 1).getPosition()) == 1) {
                    correctMoves.add(moves.get(i));
                }
            }
        }
        return correctMoves.size() >= gameProgress.getConfiguration().getGameSymbolsToWin();
    }
}
