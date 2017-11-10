package player;

import game.GameSymbol;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PlayerTest {

    @DataProvider
    public Object[][] getData(){
        return new Object[][] {{GameSymbol.O, GameSymbol.O}, {GameSymbol.X, GameSymbol.X}, {null,null}};
    }

    @Test(dataProvider = "getData")
    public void createPlayerTest(GameSymbol input, GameSymbol expected){
        //when
        Player player = new Player(input);

        //then
        Assert.assertEquals(player.getGameSymbol(), expected);
    }

    @Test
    public void createPlayerWithScore(){
        //given
        Player player = new Player(null);

        //then
        Assert.assertEquals(player.getScore().getValue(), 0);
    }

}
