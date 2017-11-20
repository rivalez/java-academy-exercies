package board;

import game.GameSymbol;
import gameHistory.GameProgress;

import java.util.Collections;
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
        Move prevMove = moves.get(0);
        int column = lastMove.getPosition() % dimensions.getX();
        boolean result = false;
        Collections.sort(moves);
        for (int i = 0; i < moves.size(); i++) {
            lastMove = moves.get(i);
            if(i + 1 < moves.size()) {
                prevMove = moves.get(i + 1);
            }
            if(lastMove.getPosition() % dimensions.getX() == column &&
                    prevMove.getPosition() - lastMove.getPosition() == dimensions.getY() ||
                    prevMove.getPosition() - lastMove.getPosition() == 0){
                counter++;
            }
            if(counter == gameProgress.getConfiguration().getGameSymbolsToWin()){
                result = true;
            }
        }
        return result;
    }
}
