package game;

import UI.Communicate;
import board.BoardDimensions;

import java.util.Scanner;


public class ConfigurationProvider {

    public BoardDimensions askForConfiguration(){
        Scanner scanner = new Scanner(System.in);
        new Communicate("Start game").getMessage();
        int x = 3;
        int y = 3;
        try{
            new Communicate("Type horizontal size of field:").getMessage();
            x = scanner.nextInt();
           new Communicate("Type vertical size of field:").getMessage();
           y = scanner.nextInt();
        } catch (Exception e) {
            new Communicate("Please provide correct input").getMessage();
            askForConfiguration();
        }
        return new BoardDimensions(x, y);
    }

    public int askForGameSymbolsToWin(){
        Scanner scanner = new Scanner(System.in);
        new Communicate("type number of game symbols necessary to win game").getMessage();
        int result = 3;
        try {
            result = scanner.nextInt();
        } catch (Exception e){
            new Communicate("Please provide correct input").getMessage();
            askForGameSymbolsToWin();
        }
        return result;
    }
}
