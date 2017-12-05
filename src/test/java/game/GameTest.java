package game;

import board.*;
import gamehistory.GameProgress;
import org.testng.Assert;
import org.testng.annotations.Test;
import player.Player;
import ui.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

@Test
public class GameTest {

    public void playerOneWinGame(){
        //given
        InputStream in = new ByteArrayInputStream("0\n3\n1\n4\n2\n".getBytes(Charset.forName("UTF-8")));
        System.setIn(in);
        MyScanner myScanner = new MyScannerImpl();
        CommunicateProvider communicateProvider = new CommunicateProvider().populate(Language.POLISH);
        Output output = new SystemPrintOut();
        PlayerInteract playerInteract = new PlayerInteract(communicateProvider, output, myScanner);
        BoardDimensions boardDimensions = new BoardDimensions(3,3);
        Configuration configuration = new Configuration(boardDimensions, 3, Language.POLISH, output);
        Game game = new Game(communicateProvider, configuration, output, playerInteract);
        GameProgress gameProgress = new GameProgress(configuration);
        List<WinResolver> resolvers = Arrays.asList(new RowResolver(), new ColumnResolver(), new DiagonalResolver());
        Player player1 = new Player(GameSymbol.O, "henio");
        Player player2 = new Player(GameSymbol.X, "jozek");
        TurnManager turn = new TurnManager(Arrays.asList(player1, player2));
        //when
        GameState state = game.start(turn, gameProgress, resolvers);

        //then
        BoardPrinter boardPrinter = new BoardPrinter(configuration);
        boardPrinter.print(gameProgress);
        Assert.assertTrue(state.equals(GameState.WIN));
        Assert.assertEquals(player1.getScore().getValue(), 3);
    }
}