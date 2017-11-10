package player;

import game.GameSymbol;

public class SymbolResolver {

    public GameSymbol resolveSymbolForSecondPlayer(GameSymbol gameSymbol){
        if(gameSymbol.equals(GameSymbol.O)) return GameSymbol.X;
        return GameSymbol.O;
    }

}
