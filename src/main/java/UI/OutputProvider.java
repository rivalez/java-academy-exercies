package UI;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OutputProvider {

    private Scanner scanner = new Scanner(System.in);

    public OutputProvider(){

    }

    public Output askForOutputType(){
        System.out.println("Press 0 for standard output, 1 for err type output");
        Output output = new SystemPrintOut();
        try {
            int symbol = scanner.nextInt();
            switch (symbol){
                case 0:
                    output = new SystemPrintOut();
                    break;
                case 1:
                    output = new SystemErrOut();
                    break;
            }
        } catch (InputMismatchException e){
            output.display("invalid number");
        }
        return output;
    }


}
