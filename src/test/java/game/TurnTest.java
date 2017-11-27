package game;

import org.testng.Assert;
import org.testng.annotations.Test;
import player.Player;

import java.util.Arrays;

@Test
public class TurnTest {

    public void turnSwitch(){
        //given
        Player player1 = new Player(GameSymbol.O, "henio");
        Player player2 = new Player(GameSymbol.X, "jozek");
        Turn turn = new Turn(Arrays.asList(player1, player2));

        //when-then
        Assert.assertEquals(turn.getNext(), player1);
        Assert.assertEquals(turn.getNext(), player2);
        Assert.assertEquals(turn.getNext(), player1);
        Assert.assertEquals(turn.getNext(), player2);

    }
}
