package board;

import game.Configuration;
import gamehistory.GameProgress;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class RowResolverTest extends RowData {

    private BoardCreator boardCreator = new BoardCreator();

    @Test(dataProvider = "getData")
    public void simpleRowTest(List<Move> moves, Configuration configuration){
        //given
        WinResolver resolver = new RowResolver();
        GameProgress gameProgress = boardCreator.createGame(moves, configuration);

        //when-then
        Assert.assertTrue(resolver.resolve(gameProgress));
    }

    @Test(dataProvider = "getInvalidData")
    public void invalidSimpleRow(List<Move> moves, Configuration configuration){
        //given
        WinResolver resolver = new RowResolver();
        GameProgress gameProgress = boardCreator.createGame(moves, configuration);

        //when-then
        Assert.assertFalse(resolver.resolve(gameProgress));
    }

}
