package player;

import game.GameSymbol;

public class SymbolResolver {

    public GameSymbol resolveSecondSymbol(GameSymbol gameSymbol){
        return gameSymbol.equals(GameSymbol.O) ? GameSymbol.X : GameSymbol.O;
    }

}
