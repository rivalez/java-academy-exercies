package game;

import board.Point2D;

import java.util.Scanner;

public class ConfigurationProvider {

    public Point2D askForConfiguration(){
        Scanner scanner = new Scanner(System.in);
        new Communicate("Start game").getMessage();
        new Communicate("Type horizontal size of field:").getMessage();
        int x = scanner.nextInt();
        new Communicate("Type vertical size of field:").getMessage();
        int y = scanner.nextInt();
        return new Point2D(x, y);
    }

    public int askForGameSymbolsToWin(){
        Scanner scanner = new Scanner(System.in);
        new Communicate("type number of game symbols necessary to win game").getMessage();
        int result = scanner.nextInt();
        return result;
    }
}
