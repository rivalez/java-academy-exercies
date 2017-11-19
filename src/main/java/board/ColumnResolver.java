package board;

import game.GameSymbol;
import gameHistory.GameProgress;

import java.util.List;
import java.util.stream.Collectors;

public class ColumnResolver implements WinResolver {

    @Override
    public boolean resolve(GameProgress gameProgress) {
        BoardDimensions dimensions = gameProgress.getConfiguration().getBoardDimensions();
        List<Move> moves = gameProgress.getMoves();

        GameSymbol symbol = moves.get(moves.size() - 1).getGameSymbol();
        moves = moves.stream().filter(c -> c.getGameSymbol().equals(symbol)).collect(Collectors.toList());
        int counter = 0;
        Move lastMove = moves.get(moves.size() - 1);
        int column = lastMove.getPosition() % dimensions.getX();
        boolean result = false;
        for (int i = 0; i < moves.size(); i++) {
            lastMove = moves.get(i);
            if(lastMove.getPosition() % dimensions.getX() == column){
                counter++;
            }
            if(counter == gameProgress.getConfiguration().getGameSymbolsToWin()){
                result = true;
            }
        }
        return result;

    }

}
