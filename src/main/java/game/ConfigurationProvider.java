package game;

import board.BoardDimensions;
import ui.Communicate;
import ui.CommunicateProvider;
import ui.MyScanner;
import ui.Output;


class ConfigurationProvider {

    private static final int DEFAULT_SIZE = 3;
    private MyScanner scanner;
    private CommunicateProvider communicatePrinter;
    private Output output;

    ConfigurationProvider(CommunicateProvider communicatePrinter, Output output, MyScanner scanner){
        this.communicatePrinter = communicatePrinter;
        this.output = output;
        this.scanner = scanner;
    }

    BoardDimensions askForConfiguration(){
        output.display(communicatePrinter.getCommunicate(Communicate.START));
        int x = DEFAULT_SIZE;
        int y = DEFAULT_SIZE;
        try{
            output.display(communicatePrinter.getCommunicate(Communicate.HORIZONTAL));
            x = Integer.valueOf(scanner.nextLine());
            output.display(communicatePrinter.getCommunicate(Communicate.VERTICAL));
            y = Integer.valueOf(scanner.nextLine());
        } catch (Exception e) {
            output.display(communicatePrinter.getCommunicate(Communicate.CORRECT_INPUT));
        }
        return new BoardDimensions(x, y);
    }

    int askForGameSymbolsToWin(){
        output.display(communicatePrinter.getCommunicate(Communicate.SYMBOL_TO_WIN));
        int result = DEFAULT_SIZE;
        try {
            result = Integer.valueOf(scanner.nextLine());
        } catch (Exception e){
            output.display(communicatePrinter.getCommunicate(Communicate.CORRECT_INPUT));
        }
        return result;
    }
}