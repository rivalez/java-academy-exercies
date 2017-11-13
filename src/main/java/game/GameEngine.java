package game;

import UI.BoardPrinter;
import board.BoardDimensions;
import board.BoardProvider;
import board.GameBoard;
import board.RowResolver;
import player.Player;
import player.SymbolResolver;
import validators.MoveValidator;
import validators.RowValidator;

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


//        Arbiter arbiter = new Arbiter();
        MoveValidator moveValidator = new MoveValidator(gameState.getBoard().size());
        PositionAsker positionAsker = new PositionAsker();
        Turn turn = new Turn(Arrays.asList(firstPlayer, secondPlayer));
        BoardPrinter boardPrinter = new BoardPrinter(gameState);
        System.out.println(boardPrinter.print());

        boolean isGameRunning = true;
        while (isGameRunning) {
            int suggestedPosition = positionAsker.askForPosition();
            RowValidator rowValidator = new RowValidator();
            if (moveValidator.validate(suggestedPosition)) {
                Move move = new Move(suggestedPosition);
                move.doMove(gameState, turn.getNext());
                RowResolver rowResolver = new RowResolver();
                isGameRunning = !rowValidator.validate(rowResolver.resolve(suggestedPosition, gameState));
            } else {
                System.out.println("wrong move bro, you lose turn");
            }
        }
        System.out.println("Game is finished! %s player won! Congratulation!");
    }

    private GameState configure() {
        ConfigurationProvider configurationProvider = new ConfigurationProvider();
        BoardDimensions boardDimensions = configurationProvider.askForConfiguration();
        int gameSymbolsToWin = configurationProvider.askForGameSymbolsToWin();
        Configuration configuration = new Configuration(boardDimensions, gameSymbolsToWin);
        GameBoard gameField = new BoardProvider().create(configuration.getBoard());
        GameState gameState = new GameState(gameField);
        gameState.listCreator();
        return gameState;
    }
}
