package game;

import UI.BoardPrinter;
import board.*;
import jdk.nashorn.internal.ir.annotations.Ignore;
import jdk.nashorn.internal.ir.annotations.Immutable;
import player.Player;
import player.SymbolResolver;
import validators.MoveValidator;
import validators.BoardPartValidator;

import javax.xml.ws.soap.Addressing;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GameEngine {

    public static void main(String[] args) {
        GameEngine gameEngine = new GameEngine();
        gameEngine.run();
    }

    public void run() {
        Configuration configuration = configure();
        GameState gameState = createGameState(configuration);

        new Communicate("Field created!").getMessage();
        new Communicate("Who start's: O or X ?").getMessage();
        Scanner scanner = new Scanner(System.in);
        String symbol = scanner.next();
        Player firstPlayer = new Player(GameSymbol.valueOf(symbol));
        SymbolResolver symbolResolver = new SymbolResolver();
        Player secondPlayer = new Player(symbolResolver.resolveSymbolForSecondPlayer(firstPlayer.getGameSymbol()));
        System.out.println(firstPlayer);
        new Communicate(String.format("Player with symbol %s starts first", firstPlayer.getGameSymbol())).getMessage();

        MoveValidator moveValidator = new MoveValidator(gameState.getBoard().size());
        PositionAsker positionAsker = new PositionAsker();
        Turn turn = new Turn(Arrays.asList(firstPlayer, secondPlayer));
        BoardPrinter boardPrinter = new BoardPrinter(gameState);
        System.out.println(boardPrinter.print());

        BoardPartValidator boardPartValidator = new BoardPartValidator(configuration);
        WinResolver rowResolver = new RowResolver();
        WinResolver columnResolver = new ColumnResolver();
        WinResolver diagonalResolver = new DiagonalResolver();

        boolean isGameRunning = true;
        while (isGameRunning) {
            int suggestedPosition = positionAsker.askForPosition();
            if (moveValidator.validate(suggestedPosition)) {
                Mover mover = new Mover(suggestedPosition);
                mover.doMove(gameState, turn.getNext());
                List<List<Move>> checks = new ArrayList<>();
                checks.add(columnResolver.resolve(suggestedPosition, gameState));
                checks.add(rowResolver.resolve(suggestedPosition, gameState));
                checks.add(diagonalResolver.resolve(suggestedPosition, gameState));

                for(List<Move> part : checks){
                    if (boardPartValidator.validate(part)) {
                        isGameRunning = false;
                    }
                }
            } else {
                System.out.println("Wrong move dude, you lost turn!");
            }
        }
        System.out.println("Game is finished! %s player won! Congratulation!");
    }

    private Configuration configure() {
        ConfigurationProvider configurationProvider = new ConfigurationProvider();
        BoardDimensions boardDimensions = configurationProvider.askForConfiguration();
        int gameSymbolsToWin = configurationProvider.askForGameSymbolsToWin();
        return new Configuration(boardDimensions, gameSymbolsToWin);

    }

    private GameState createGameState(Configuration configuration) {
        GameBoard gameField = new BoardProvider().create(configuration.getBoardDimensions());
        GameState gameState = new GameState(gameField);
        gameState.listCreator();
        return gameState;
    }
}
