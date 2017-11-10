package game;

import board.FieldProvider;
import board.GameField;
import board.MoveValidator;
import board.Point2D;
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

    public void run() {
        GameState gameState = configure();

        new Communicate("Field created!").getMessage();
        new Communicate("Who start's: O or X ?").getMessage();
        Scanner scanner = new Scanner(System.in);
        String symbol = scanner.next();
        Player firstPlayer = new Player(GameSymbol.valueOf(symbol));
        SymbolResolver symbolResolver = new SymbolResolver();
        Player secondPlayer = new Player(symbolResolver.resolveSymbolForSecondPlayer(firstPlayer.getGameSymbol()));
        System.out.println(firstPlayer);
        new Communicate(String.format("Player with symbol %s starts first", firstPlayer.getGameSymbol())).getMessage();

        //todo tura
        Move move = new Move();
        Arbiter arbiter = new Arbiter();
        MoveValidator moveValidator = new MoveValidator();
        while (arbiter.isRunning()) {
            List<Player> players = Arrays.asList(firstPlayer, secondPlayer);
            moveValidator.validate(move.doMove(gameState, players.get(0)));
            moveValidator.validate(move.doMove(gameState, players.get(1)));
        }
    }

    private GameState configure() {
        ConfigurationProvider configurationProvider = new ConfigurationProvider();
        Point2D point2D = configurationProvider.askForConfiguration();
        int gameSymbolsToWin = configurationProvider.askForGameSymbolsToWin();
        Configuration configuration = new Configuration(point2D, gameSymbolsToWin);
        GameField gameField = new FieldProvider().create(configuration.getBoard());
        GameState gameState = new GameState(gameField);
        gameState.listCreator();
        return gameState;
    }
}
