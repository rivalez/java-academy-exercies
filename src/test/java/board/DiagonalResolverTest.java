package board;

import game.Configuration;
import gameHistory.GameProgress;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DiagonalResolverTest extends DiagonalData {

    private BoardCreator boardCreator = new BoardCreator();

    @Test(dataProvider = "getData")
    public void simpleDiagonalTest(List<Move> moves, Configuration configuration) {
        //given
        WinResolver resolver = new DiagonalResolver();
        GameProgress gameProgress = boardCreator.createGame(moves, configuration);

        //when-then
        Assert.assertTrue(resolver.resolve(gameProgress));
    }


}
