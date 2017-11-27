package game;

import UI.*;
import board.*;
import gameHistory.GameProgress;
import player.Player;
import player.SymbolResolver;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GameEngine {

    public static void main(String[] args) {
        GameEngine gameEngine = new GameEngine();
        gameEngine.run();
    }

    private void run() {
        OutputProvider outputProvider = new OutputProvider();
        Output output = outputProvider.askForOutputType();

        LanguageProvider languageProvider = new LanguageProvider(output);
        Language language = languageProvider.askForLanguage();

        CommunicateProvider communicateProvider = new CommunicateProvider().populate(language);

        output.display(communicateProvider.getCommunicate(Communicate.GAME));
        output.display(communicateProvider.getCommunicate(Communicate.RULES));
        output.display(communicateProvider.getCommunicate(Communicate.EXIT));
        Configuration configuration = new ConfigurationValidator(communicateProvider, output, language).check(configure(language, output));
        PlayerInteract playerInteract = new PlayerInteract(communicateProvider, output);
        output.display(communicateProvider.getCommunicate(Communicate.CREATED));
        Scanner scanner = new Scanner(System.in, "UTF-8");
        SymbolResolver symbolResolver = new SymbolResolver();
        GameSymbol gameSymbol = playerInteract.askForSymbol();
        output.display(communicateProvider.getCommunicate(Communicate.FIRST_PLAYER));
        String name = scanner.next();
        Player firstPlayer = new Player(gameSymbol, name);
        output.display(communicateProvider.getCommunicate(Communicate.SECOND_PLAYER));
        name = scanner.next();
        Player secondPlayer = new Player(symbolResolver.resolveSecondSymbol(firstPlayer.getGameSymbol()), name);
        output.display(communicateProvider.getCommunicate(Communicate.FIRST_PLAYER) + firstPlayer.toString());

        Turn turn = new Turn(Arrays.asList(firstPlayer, secondPlayer));
        BoardPrinter boardPrinter = new BoardPrinter(configuration);
        List<WinResolver> resolvers = Arrays.asList(new RowResolver(), new ColumnResolver(), new DiagonalResolver());

        int numbersOfGames = 3;
        while (numbersOfGames > 0) {
            output.display(boardPrinter.print());
            new Game(communicateProvider, configuration, output).start(turn, new GameProgress(configuration), resolvers);
            numbersOfGames--;
        }

    }

    private Configuration configure(Language language, Output output) {
        CommunicateProvider communicatePrinter = new CommunicateProvider().populate(language);
        ConfigurationProvider configurationProvider = new ConfigurationProvider(communicatePrinter, output);
        BoardDimensions boardDimensions = configurationProvider.askForConfiguration();
        int gameSymbolsToWin = configurationProvider.askForGameSymbolsToWin();
        return new Configuration(boardDimensions, gameSymbolsToWin, language, output);
    }
}