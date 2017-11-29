package board;

import game.Configuration;
import gamehistory.GameProgress;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

@Test
public class CounterDiagonalResolverTest extends DiagonalData {

    private BoardCreator boardCreator = new BoardCreator();

    @Test(dataProvider = "getCorrect")
    public void leftToRightCorrect(List<Move> moves, Configuration configuration){
        //given
        WinResolver resolver = new CounterDiagonalResolver();
        GameProgress gameProgress = boardCreator.createGame(moves, configuration);

        //when-then
        Assert.assertTrue(resolver.resolve(gameProgress));
    }

    @Test(dataProvider = "getInvalid")
    public void leftToRightInvalid(List<Move> moves, Configuration configuration){
        //given
        WinResolver resolver = new CounterDiagonalResolver();
        GameProgress gameProgress = boardCreator.createGame(moves, configuration);

        //when-then
        Assert.assertFalse(resolver.resolve(gameProgress));
    }
}