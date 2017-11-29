package game;

import board.BoardDimensions;
import ui.Communicate;
import ui.CommunicateProvider;
import ui.Language;
import ui.Output;

class ConfigurationValidator {

    private static final int MAX = 100;
    private static final int MIN = 3;

    private CommunicateProvider communicateProvider;
    private Output output;
    private Language language;

    ConfigurationValidator(CommunicateProvider communicateProvider, Output output, Language language){
        this.output = output;
        this.communicateProvider = communicateProvider;
        this.language = language;
    }

    Configuration check(Configuration configuration){
        if(isValid(configuration)){
            return configuration;
        }
        output.display(communicateProvider.getCommunicate(Communicate.INCORRECT_CONFIG));
        BoardDimensions boardDimensions = new BoardDimensions(MIN,MIN);
        return new Configuration(boardDimensions, MIN, language, output);
    }

    private boolean isValid(Configuration configuration) {
        return (configuration.getGameSymbolsToWin() >= MIN && isRowValid(configuration))
                && (isColumnValid(configuration) && configuration.getGameSymbolsToWin() >= MIN) && isTooBig(configuration);
    }

    private boolean isTooBig(Configuration configuration) {
        return configuration.getBoardDimensions().getX() <= MAX && configuration.getBoardDimensions().getY() <= MAX;
    }

    private boolean isRowValid(Configuration configuration){
        return configuration.getBoardDimensions().getX() >= MIN && configuration.getBoardDimensions().getX() >= configuration.getGameSymbolsToWin();
    }

    private boolean isColumnValid(Configuration configuration){
        return configuration.getBoardDimensions().getY() >= MIN && configuration.getBoardDimensions().getY() >= configuration.getGameSymbolsToWin();
    }

}
