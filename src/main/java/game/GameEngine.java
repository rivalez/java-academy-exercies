package game;

import UI.BoardPrinter;
import board.*;
import player.Player;
import player.SymbolResolver;
import validators.MoveValidator;
import validators.boardPartValidator;

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


//        Arbiter arbiter = new Arbiter();
        MoveValidator moveValidator = new MoveValidator(gameState.getBoard().size());
        PositionAsker positionAsker = new PositionAsker();
        Turn turn = new Turn(Arrays.asList(firstPlayer, secondPlayer));
        BoardPrinter boardPrinter = new BoardPrinter(gameState);
        System.out.println(boardPrinter.print());

        boolean isGameRunning = true;
        while (isGameRunning) {
            int suggestedPosition = positionAsker.askForPosition();
            boardPartValidator boardPartValidator = new boardPartValidator(configuration);
            if (moveValidator.validate(suggestedPosition)) {
                Move move = new Move(suggestedPosition);
                move.doMove(gameState, turn.getNext());
                RowResolver rowResolver = new RowResolver();
                ColumnResolver columnResolver = new ColumnResolver();
                List<Field> column = columnResolver.resolve(suggestedPosition, gameState);
                List<Field> row = rowResolver.resolve(suggestedPosition, gameState);

                if (boardPartValidator.validate(row)) {
                    isGameRunning = false;
                }
                if (boardPartValidator.validate(column)) {
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

    private GameState createGameState(Configuration configuration) {
        GameBoard gameField = new BoardProvider().create(configuration.getBoardDimensions());
        GameState gameState = new GameState(gameField);
        gameState.listCreator();
        return gameState;
    }
}
