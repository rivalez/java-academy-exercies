package UI;

import java.util.Scanner;

public class LanguageProvider {

    private Output output;
    private Scanner scanner = new Scanner(System.in);

    public LanguageProvider(Output output){
        this.output = output;
    }

    public Language askForLanguage(){
        output.display("Press 0 for English, 1 for Polish Language");
        int symbol = scanner.nextInt();
        Language language = Language.ENGLISH;
        try {
            switch (symbol){
                case 0:
                    language = Language.ENGLISH;
                    break;
                case 1:
                    language = Language.POLISH;
                    break;
            }
        } catch (NumberFormatException e){
            output.display("invalid number");
            askForLanguage();
        }
        return language;
    }
}
