package game;

import UI.CommunicatePrinter;
import board.BoardDimensions;

import java.util.Scanner;


public class ConfigurationProvider {

    private Scanner scanner = new Scanner(System.in);
    private CommunicatePrinter communicatePrinter;

    public ConfigurationProvider(CommunicatePrinter communicatePrinter){
        this.communicatePrinter = communicatePrinter;
    }

    BoardDimensions askForConfiguration(){
        communicatePrinter.getStart();
//        new CommunicatePrinter("Start game").getMessage();
        int x = 3;
        int y = 3;
        try{
//            new CommunicatePrinter("Type horizontal size of field:").getMessage();
            x = scanner.nextInt();
//           new CommunicatePrinter("Type vertical size of field:").getMessage();
           y = scanner.nextInt();
        } catch (Exception e) {
//            new CommunicatePrinter("Please provide correct input").getMessage();
            askForConfiguration();
        }
        return new BoardDimensions(x, y);
    }

    int askForGameSymbolsToWin(){
//        new CommunicatePrinter("Type number of game symbols necessary to win game").getMessage();
        int result = 3;
        try {
            result = scanner.nextInt();
        } catch (Exception e){
//            new CommunicatePrinter("Please provide correct input").getMessage();
            askForGameSymbolsToWin();
        }
        return result;
    }
}
