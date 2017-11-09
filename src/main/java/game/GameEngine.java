package game;

import UI.BoardPrinter;
import board.FieldProvider;
import board.GameField;
import board.Point2D;
import player.Player;

import java.util.Scanner;

public class GameEngine {

    public static void main(String[] args) {
        GameEngine gameEngine = new GameEngine();
        gameEngine.run();
    }

    public void run() {
//        while(configuration.isStart()){
        ConfigurationProvider configurationProvider = new ConfigurationProvider();
        Point2D point2D = configurationProvider.askForConfiguration();
        int gameSymbolsToWin = configurationProvider.askForGameSymbolsToWin();
        Configuration configuration = new Configuration(point2D, gameSymbolsToWin);
        GameField gameField = new FieldProvider().create(configuration.getBoard());
        new Communicate("Field created!").getMessage();
        new Communicate("Who start's: O or X ?").getMessage();
        Scanner scanner = new Scanner(System.in);
        String symbol = scanner.next();
        Player player = new Player(GameSymbol.valueOf(symbol));
        System.out.println(player);
        new Communicate(String.format("Player with symbol %s starts first", player.getGameSymbol())).getMessage();

        //todo tura
        new Communicate("please type number in which you want to place your symbol ").getMessage();
        int position = scanner.nextInt();
        GameState gameState = new GameState(gameField);
        gameState.listCreator();
        gameState.addElement(position, player.getGameSymbol());

        BoardPrinter boardPrinter = new BoardPrinter(gameState);
        System.out.println(boardPrinter.print());




//            break;
//        }
    }
}
