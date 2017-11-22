package game;

import UI.BoardPrinter;
import UI.Communicate;
import board.*;
import gameHistory.GameProgress;
import player.Player;
import player.SymbolResolver;
import validators.MoveValidator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GameEngine {

    public static void main(String[] args) {
        GameEngine gameEngine = new GameEngine();
        gameEngine.run();
    }

    private void run() {
        Configuration configuration = new ConfigurationValidator().check(configure());

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

        new Communicate(String.format("Player %s with symbol %s starts first", firstPlayer.getName(), firstPlayer.getGameSymbol().name())).getMessage();

        Turn turn = new Turn(Arrays.asList(firstPlayer, secondPlayer));
        MoveValidator moveValidator = new MoveValidator(configuration.getBoardDimensions().getX() * configuration.getBoardDimensions().getY());
        BoardPrinter boardPrinter = new BoardPrinter(configuration);
        List<WinResolver> resolvers = Arrays.asList(new RowResolver(), new ColumnResolver(), new DiagonalResolver());

        int numbersOfGames = 3;
        while (numbersOfGames > 0) {
            System.out.println(boardPrinter.print());
            new Game(moveValidator, configuration).start(turn, new GameProgress(configuration), resolvers);
            numbersOfGames--;
        }

    }

    private Configuration configure() {
        ConfigurationProvider configurationProvider = new ConfigurationProvider();
        BoardDimensions boardDimensions = configurationProvider.askForConfiguration();
        int gameSymbolsToWin = configurationProvider.askForGameSymbolsToWin();
        return new Configuration(boardDimensions, gameSymbolsToWin);
    }
}