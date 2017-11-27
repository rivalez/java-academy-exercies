package player;

import game.GameSymbol;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class PlayerTest {
    public void toStringTest(){
        //given
        Player player = new Player(GameSymbol.O, "zbysio");

        //when-then
        Assert.assertEquals(player.toString(), "zbysio  -   O   -  score=0");

    }
}