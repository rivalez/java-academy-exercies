package board;

import game.GameSymbol;
import gameHistory.GameProgress;

import java.util.List;
import java.util.stream.Collectors;

public class RowResolver implements WinResolver {

    @Override
    public boolean resolve(GameProgress gameProgress) {
        BoardDimensions dimensions = gameProgress.getConfiguration().getBoardDimensions();
        List<Move> moves = gameProgress.getMoves();

        GameSymbol symbol = moves.get(moves.size() - 1).getGameSymbol();
        moves = moves.stream().filter(c -> c.getGameSymbol().equals(symbol)).collect(Collectors.toList());
        int counter = 1;
        Move lastMove = moves.get(moves.size() - 1);
        int row = lastMove.getPosition() / dimensions.getX();
        for (int i = 0; i < moves.size(); i++) {
            if(counter == gameProgress.getConfiguration().getGameSymbolsToWin()){
                return true;
            }
            lastMove = moves.get(i);
            if(lastMove.getPosition() / dimensions.getX() == row){
                counter++;
            }
        }
        return false;
    }
}
