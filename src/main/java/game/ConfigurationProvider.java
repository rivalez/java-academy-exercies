package game;

import UI.*;
import board.BoardDimensions;

import java.util.Scanner;


class ConfigurationProvider {

    private Scanner scanner = new Scanner(System.in);
    private CommunicateProvider communicatePrinter;
    private Output output;

    ConfigurationProvider(CommunicateProvider communicatePrinter, Output output){
        this.communicatePrinter = communicatePrinter;
        this.output = output;
    }

    BoardDimensions askForConfiguration(){
        output.display(communicatePrinter.getCommunicate(Communicate.START));
        int x = 3;
        int y = 3;
        try{
            output.display(communicatePrinter.getCommunicate(Communicate.HORIZONTAL));
            x = scanner.nextInt();
            output.display(communicatePrinter.getCommunicate(Communicate.VERTICAL));
            y = scanner.nextInt();
        } catch (Exception e) {
            output.display(communicatePrinter.getCommunicate(Communicate.CORRECT_INPUT));
            askForConfiguration();
        }
        return new BoardDimensions(x, y);
    }

    int askForGameSymbolsToWin(){
        output.display(communicatePrinter.getCommunicate(Communicate.SYMBOL_TO_WIN));
        int result = 3;
        try {
            result = scanner.nextInt();
        } catch (Exception e){
            output.display(communicatePrinter.getCommunicate(Communicate.CORRECT_INPUT));
            askForGameSymbolsToWin();
        }
        return result;
    }
}