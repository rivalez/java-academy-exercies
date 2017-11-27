package game;

import org.testng.Assert;
import org.testng.annotations.Test;
import player.Player;

import java.util.Arrays;
import java.util.List;

@Test
public class ArbiterTest {

    private Arbiter arbiter = new Arbiter();

    public void admitWin(){
        //given
        Player player = new Player(GameSymbol.O, "henio");

        //when
        arbiter.admitPoints(player);

        //then
        Assert.assertEquals(player.getScore().getValue(), 3);
    }


    public void admitDraw(){
        //given
        Player player1 = new Player(GameSymbol.O, "henio");
        Player player2 = new Player(GameSymbol.X, "jozek");
        List<Player> players = Arrays.asList(player1, player2);

        //when
        arbiter.admitPoints(players);

        //then
        Assert.assertEquals(players.get(0).getScore().getValue(), 1);
        Assert.assertEquals(players.get(1).getScore().getValue(), 1);
    }

    public void admitDrawAndWin(){
        //given
        Player player1 = new Player(GameSymbol.O, "henio");
        Player player2 = new Player(GameSymbol.X, "jozek");
        List<Player> players = Arrays.asList(player1, player2);

        //when
        arbiter.admitPoints(players);
        arbiter.admitPoints(player1);

        //then
        Assert.assertEquals(players.get(0).getScore().getValue(), 4);
        Assert.assertEquals(players.get(1).getScore().getValue(), 1);
    }
}
