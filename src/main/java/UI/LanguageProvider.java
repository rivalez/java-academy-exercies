package UI;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LanguageProvider {

    private Output output;
    private Scanner scanner;

    public LanguageProvider(Output output){
        this.output = output;
        this.scanner = new Scanner(System.in, "UTF-8");
    }

    public Language askForLanguage(){
        output.display("Press 0 for English, 1 for Polish Language");
        Language language = Language.ENGLISH;
        try {
            int symbol = scanner.nextInt();
            switch (symbol){
                case 0:
                    language = Language.ENGLISH;
                    break;
                case 1:
                    language = Language.POLISH;
                    break;
                default:
                    language = Language.ENGLISH;
                    break;
            }
        } catch (InputMismatchException e){
            output.display("invalid number");
        }
        return language;
    }
}
