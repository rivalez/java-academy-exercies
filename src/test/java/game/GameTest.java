package game;

import UI.*;
import board.*;
import gameHistory.GameProgress;
import org.testng.annotations.Test;
import player.Player;

import java.util.Arrays;
import java.util.List;

@Test
public class GameTest {

//    public void playerOneWinGame(){
//        //given
//        CommunicateProvider communicateProvider = new CommunicateProvider().populate(Language.POLISH);
//        Output output = new SystemPrintOut();
//        BoardDimensions boardDimensions = new BoardDimensions(3,3);
//        Configuration configuration = new Configuration(boardDimensions, 3);
//        Game game = new Game(communicateProvider, configuration, output);
//        GameProgress gameProgress = new GameProgress(configuration);
//        List<WinResolver> resolvers = Arrays.asList(new RowResolver(), new ColumnResolver(), new DiagonalResolver());
//        Player player1 = new Player(GameSymbol.O, "henio");
//        Player player2 = new Player(GameSymbol.X, "jozek");
//        Turn turn = new Turn(Arrays.asList(player1, player2));
//        //when
//        game.start(turn, gameProgress, resolvers);
//
//        //then
//        BoardPrinter boardPrinter = new BoardPrinter(configuration);
//        boardPrinter.print(gameProgress);
//
//    }

}
