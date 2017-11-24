package game;

import UI.*;
import board.BoardDimensions;

import java.util.Scanner;


public class ConfigurationProvider {

    private Scanner scanner = new Scanner(System.in);
    private CommunicateProvider communicatePrinter;
    private Output printOut = new SystemPrintOut();
    private Output printErr = new SystemErrOut();

    public ConfigurationProvider(CommunicateProvider communicatePrinter){
        this.communicatePrinter = communicatePrinter;
    }

    BoardDimensions askForConfiguration(){
        printOut.display(communicatePrinter.getCommunicate(Communicate.START));
        int x = 3;
        int y = 3;
        try{
            printOut.display(communicatePrinter.getCommunicate(Communicate.HORIZONTAL));
            x = scanner.nextInt();
            printOut.display(communicatePrinter.getCommunicate(Communicate.VERTICAL));
            y = scanner.nextInt();
        } catch (Exception e) {
            printErr.display(communicatePrinter.getCommunicate(Communicate.CORRECT_INPUT));
            askForConfiguration();
        }
        return new BoardDimensions(x, y);
    }

    int askForGameSymbolsToWin(){
        printOut.display(communicatePrinter.getCommunicate(Communicate.SYMBOL_TO_WIN));
        int result = 3;
        try {
            result = scanner.nextInt();
        } catch (Exception e){
            printErr.display(communicatePrinter.getCommunicate(Communicate.CORRECT_INPUT));
            askForGameSymbolsToWin();
        }
        return result;
    }
}