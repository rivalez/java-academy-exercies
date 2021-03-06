package player;

import game.GameSymbol;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SymbolResolverTest {

    @DataProvider
    public Object[][] getData(){
        return new Object[][]{{GameSymbol.O, GameSymbol.X}, {GameSymbol.X, GameSymbol.O}};
    }

    @Test(dataProvider = "getData")
    public void resolveSecondPlayerSymbol(GameSymbol input, GameSymbol expected){
        SymbolResolver symbolResolver = new SymbolResolver();
        GameSymbol symbol = symbolResolver.resolveSecondSymbol(input);
        Assert.assertEquals(symbol, expected);
    }
}
