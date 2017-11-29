package board;

import game.Configuration;
import gameHistory.GameProgress;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

@Test
public class RightToLeftTest extends DiagonalData {

    private BoardCreator boardCreator = new BoardCreator();

    @Test(dataProvider = "getLeftToRight")
    public void leftToRightCorrect(List<Move> moves, Configuration configuration){
        //given
        WinResolver resolver = new RightToLeft();
        GameProgress gameProgress = boardCreator.createGame(moves, configuration);

        //when-then
        Assert.assertTrue(resolver.resolve(gameProgress));
    }

    @Test(dataProvider = "getLeftToRightInvalid")
    public void leftToRightInvalid(List<Move> moves, Configuration configuration){
        //given
        WinResolver resolver = new RightToLeft();
        GameProgress gameProgress = boardCreator.createGame(moves, configuration);

        //when-then
        Assert.assertFalse(resolver.resolve(gameProgress));
    }
}