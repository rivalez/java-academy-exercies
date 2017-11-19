package board;

import game.GameSymbol;
import gameHistory.GameProgress;

import java.util.List;
import java.util.stream.Collectors;

public class DiagonalResolver implements WinResolver {

    @Override
    public boolean resolve(GameProgress gameProgress) {
        BoardDimensions dimensions = gameProgress.getConfiguration().getBoardDimensions();
        List<Move> moves = gameProgress.getMoves();

        GameSymbol symbol = moves.get(moves.size() - 1).getGameSymbol();
        moves = moves.stream().filter(c -> c.getGameSymbol().equals(symbol)).collect(Collectors.toList());
        int counter = 1;
        for (int i = 0; i < moves.size(); i++) {
            Move lastMove = moves.get(i);
            int row = lastMove.getPosition() / dimensions.getX();
            int column = lastMove.getPosition() % dimensions.getX();
            if(lastMove.getPosition() / dimensions.getX() == row
                    && lastMove.getPosition() % dimensions.getX() == column){
                counter++;
            }
        }
        return counter == gameProgress.getConfiguration().getGameSymbolsToWin();
    }
}
