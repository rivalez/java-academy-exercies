package game;

import board.BoardDimensions;

import java.util.Scanner;

public class ConfigurationProvider {

    public BoardDimensions askForConfiguration(){
        Scanner scanner = new Scanner(System.in);
        new Communicate("Start game").getMessage();
        new Communicate("Type horizontal size of field:").getMessage();
        int x = scanner.nextInt();
        new Communicate("Type vertical size of field:").getMessage();
        int y = scanner.nextInt();
        return new BoardDimensions(x, y);
    }

    public int askForGameSymbolsToWin(){
        Scanner scanner = new Scanner(System.in);
        new Communicate("type number of game symbols necessary to win game").getMessage();
        int result = scanner.nextInt();
        return result;
    }
}
