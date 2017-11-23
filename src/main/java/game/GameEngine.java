package game;

import UI.BoardPrinter;
import UI.CommunicatePrinter;
import UI.Language;
import UI.PlayerInteract;
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
//        new CommunicatePrinter("OX-GAME-1.0 BETA. ENJOY.").getMessage();
//        new CommunicatePrinter("To Exit Game press combination of ctrl + z").getMessage();
        Configuration configuration = new ConfigurationValidator().check(configure());
        PlayerInteract playerInteract = new PlayerInteract();
//        new CommunicatePrinter("Field created!").getMessage();
        Scanner scanner = new Scanner(System.in);
        SymbolResolver symbolResolver = new SymbolResolver();
        GameSymbol gameSymbol = playerInteract.askForSymbol();
//        new CommunicatePrinter("Provide Name of first player: ").getMessage();
        String name = scanner.next();
        Player firstPlayer = new Player(gameSymbol, name);

//        new CommunicatePrinter("Provide Name of second player: ").getMessage();
        name = scanner.next();
        Player secondPlayer = new Player(symbolResolver.resolveSecondSymbol(firstPlayer.getGameSymbol()), name);

//        new CommunicatePrinter(String.format("Player %s starts first", firstPlayer.toString())).getMessage();

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
        //todo langauge resolver
        Language language = Language.ENGLISH;
        CommunicatePrinter communicatePrinter = new CommunicatePrinter(language);
        ConfigurationProvider configurationProvider = new ConfigurationProvider(communicatePrinter);
        BoardDimensions boardDimensions = configurationProvider.askForConfiguration();
        int gameSymbolsToWin = configurationProvider.askForGameSymbolsToWin();
        return new Configuration(boardDimensions, gameSymbolsToWin);
    }
}