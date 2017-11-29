package game;

import UI.*;
import board.*;
import gameHistory.GameProgress;
import player.Player;
import player.SymbolResolver;

import java.util.Arrays;
import java.util.List;

public class GameEngine {

    public static void main(String[] args) {
        GameEngine gameEngine = new GameEngine();
        MyScanner myScanner = new MyScannerImpl();
        gameEngine.run(myScanner);
    }

    void run(MyScanner myScanner) {
        OutputProvider outputProvider = new OutputProvider(myScanner);
        Output output = outputProvider.askForOutputType();

        LanguageProvider languageProvider = new LanguageProvider(output, myScanner);
        Language language = languageProvider.askForLanguage();

        CommunicateProvider communicateProvider = new CommunicateProvider().populate(language);

        output.display(communicateProvider.getCommunicate(Communicate.GAME));
        output.display(communicateProvider.getCommunicate(Communicate.RULES));
        output.display(communicateProvider.getCommunicate(Communicate.EXIT));
        Configuration configuration = new ConfigurationValidator(communicateProvider, output, language).check(configure(language, output, myScanner));
        PlayerInteract playerInteract = new PlayerInteract(communicateProvider, output, myScanner);
        output.display(communicateProvider.getCommunicate(Communicate.CREATED));
        Turn turn = createTurn(myScanner, output, communicateProvider, playerInteract);
        BoardPrinter boardPrinter = new BoardPrinter(configuration);
        List<WinResolver> resolvers = Arrays.asList(new RowResolver(), new ColumnResolver(), new DiagonalResolver(), new CounterDiagonalResolver());

        int numbersOfGames = 3;
        while (numbersOfGames > 0) {
            output.display(boardPrinter.print());
            new Game(communicateProvider, configuration, output, playerInteract).start(turn, new GameProgress(configuration), resolvers);
            numbersOfGames--;
        }
        GameManager gameManager = new GameManager(turn, communicateProvider);
        output.display(gameManager.result());
    }

    private Turn createTurn(MyScanner myScanner, Output output, CommunicateProvider communicateProvider, PlayerInteract playerInteract) {
        SymbolResolver symbolResolver = new SymbolResolver();
        Player firstPlayer = createFirstPlayer(output, communicateProvider, playerInteract, myScanner);
        Player secondPlayer = createSecondPlayer(output, communicateProvider, myScanner, symbolResolver, firstPlayer);
        output.display(String.format(communicateProvider.getCommunicate(Communicate.START_FIRST),firstPlayer.toString()));

        return new Turn(Arrays.asList(firstPlayer, secondPlayer));
    }

    private Player createSecondPlayer(Output output, CommunicateProvider communicateProvider, MyScanner scanner, SymbolResolver symbolResolver, Player firstPlayer) {
        output.display(communicateProvider.getCommunicate(Communicate.SECOND_PLAYER));
        String name = scanner.nextLine();
        return new Player(symbolResolver.resolveSecondSymbol(firstPlayer.getGameSymbol()), name);
    }

    private Player createFirstPlayer(Output output, CommunicateProvider communicateProvider, PlayerInteract playerInteract, MyScanner scanner) {
        GameSymbol gameSymbol = playerInteract.askForSymbol();
        output.display(communicateProvider.getCommunicate(Communicate.FIRST_PLAYER));
        String name = scanner.nextLine();
        return new Player(gameSymbol, name);
    }

    private Configuration configure(Language language, Output output, MyScanner myScanner) {
        CommunicateProvider communicatePrinter = new CommunicateProvider().populate(language);
        ConfigurationProvider configurationProvider = new ConfigurationProvider(communicatePrinter, output, myScanner);
        BoardDimensions boardDimensions = configurationProvider.askForConfiguration();
        int gameSymbolsToWin = configurationProvider.askForGameSymbolsToWin();
        return new Configuration(boardDimensions, gameSymbolsToWin, language, output);
    }

}