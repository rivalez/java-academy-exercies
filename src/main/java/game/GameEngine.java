package game;

import UI.BoardPrinter;
import board.*;
import gameHistory.GameProgress;
import player.Player;
import player.SymbolResolver;
import validators.MoveValidator;

import java.util.Arrays;
import java.util.Scanner;

public class GameEngine {

    public static void main(String[] args) {
        GameEngine gameEngine = new GameEngine();
        gameEngine.run();
    }

    public void run() {
        Configuration configuration = new ConfiguratorChecker().check(configure());

        new Communicate("Field created!").getMessage();
        new Communicate("Who start's: O or X ?").getMessage();
        Scanner scanner = new Scanner(System.in);
        String symbol = scanner.next();
        SymbolResolver symbolResolver = new SymbolResolver();
        new Communicate("Provide Name of first player: ").getMessage();
        String name = scanner.next();
        Player firstPlayer = new Player(GameSymbol.valueOf(symbol), name);

        new Communicate("Provide Name of second player: ").getMessage();
        name = scanner.next();
        Player secondPlayer = new Player(symbolResolver.resolveSymbolForSecondPlayer(firstPlayer.getGameSymbol()), name);

        new Communicate(String.format("Player %s with symbol %s starts first",firstPlayer.getName(), firstPlayer.getGameSymbol().name())).getMessage();

        Turn turn = new Turn(Arrays.asList(firstPlayer, secondPlayer));
        MoveValidator moveValidator = new MoveValidator(configuration.getBoardDimensions().getX() * configuration.getBoardDimensions().getY());
        PositionAsker positionAsker = new PositionAsker();
        BoardPrinter boardPrinter = new BoardPrinter(configuration);

        WinResolver rowResolver = new RowResolver();
        WinResolver columnResolver = new ColumnResolver();
        WinResolver diagonalResolver = new DiagonalResolver();
        System.out.println(boardPrinter.print());
        GameProgress gameProgress = new GameProgress(configuration);

        boolean isGameRunning = true;
        while (isGameRunning) {
            int suggestedPosition = positionAsker.askForPosition();
            if (moveValidator.validate(suggestedPosition)) {
                Player currentPlayer = turn.getNext();
                gameProgress.addMove(new Move(suggestedPosition, currentPlayer.getGameSymbol()));

                System.out.println(boardPrinter.print(gameProgress));

                if(rowResolver.resolve(gameProgress) || columnResolver.resolve(gameProgress)){
                    isGameRunning = false;
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

}
