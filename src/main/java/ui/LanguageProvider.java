package ui;

public class LanguageProvider {

    private Output output;
    private MyScanner scanner;

    public LanguageProvider(Output output, MyScanner scanner){
        this.output = output;
        this.scanner = scanner;
    }

    public Language askForLanguage(){
        output.display("Press 0 for English, 1 for Polish Language");
        Language language = Language.ENGLISH;
        try {
            int symbol = Integer.valueOf(scanner.nextLine());
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
        } catch (Exception e){
            output.display("invalid number");
        }
        return language;
    }
}
