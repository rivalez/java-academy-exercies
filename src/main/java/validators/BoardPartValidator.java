package validators;

import board.Move;
import game.Configuration;

import java.util.List;

public class BoardPartValidator {

    private Configuration configuration;

    public BoardPartValidator(Configuration configuration){
        this.configuration = configuration;
    }

    public boolean validate(List<Move> moves) {
        int symbolsToWin = configuration.getGameSymbolsToWin() - 1;
        int counter = 0;
        for (int i = 0; i < moves.size(); i++) {
            if(i + 1 < moves.size()){
                if(isNotNull(moves, i) && isNotTheSame(moves, i) && isSymbolEquals(moves, i)){
                    counter++;
                    if (counter == symbolsToWin) return true;
                } else {
                    counter = 0;
                }
            }
        }
        return false;
    }

    private boolean isSymbolEquals(List<Move> moves, int i) {
        return moves.get(i).getGameSymbol().equals(moves.get(i+1).getGameSymbol());
    }

    private boolean isNotNull(List<Move> moves, int i) {
        return moves.get(i).getGameSymbol() != null && moves.get(i + 1).getGameSymbol() != null;
    }

    private boolean isNotTheSame(List<Move> moves, int i) {
        return !moves.get(i).equals(moves.get(i + 1));
    }
}
