package board;

import game.Configuration;
import gameHistory.GameProgress;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ColumnResolverTest extends ColumnData {

    private BoardCreator boardCreator = new BoardCreator();

    @Test(dataProvider = "getData")
    public void simpleColumn(List<Move> moves, Configuration configuration){
        //given
        WinResolver resolver = new ColumnResolver();
        GameProgress gameProgress = boardCreator.createGame(moves, configuration);

        //when-then
        Assert.assertTrue(resolver.resolve(gameProgress));
    }

    @Test(dataProvider = "getAssertFailData")
    public void invalidColumnMoves(List<Move> moves, Configuration configuration) {
        //given
        WinResolver resolver = new ColumnResolver();
        GameProgress gameProgress = boardCreator.createGame(moves, configuration);

        //when-then
        Assert.assertFalse(resolver.resolve(gameProgress));
    }
}