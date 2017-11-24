package game;

import UI.Communicate;
import UI.CommunicateProvider;
import UI.Output;
import UI.SystemPrintOut;
import board.BoardDimensions;

class ConfigurationValidator {

    private static final int MAX = 100;

    private CommunicateProvider communicateProvider;
    private Output output = new SystemPrintOut();

    ConfigurationValidator(CommunicateProvider communicateProvider){
        this.communicateProvider = communicateProvider;
    }

    Configuration check(Configuration configuration){
        if(isValid(configuration)){
            return configuration;
        }
        output.display(communicateProvider.getCommunicate(Communicate.INCORRECT_CONFIG));
        BoardDimensions boardDimensions = new BoardDimensions(3,3);
        return new Configuration(boardDimensions, 3);
//        Optional
    }

    private boolean isValid(Configuration configuration) {
        return (configuration.getGameSymbolsToWin() >= 3 && isRowValid(configuration))
                && (isColumnValid(configuration) && configuration.getGameSymbolsToWin() >= 3) && isTooBig(configuration);
    }

    private boolean isTooBig(Configuration configuration) {
        return configuration.getBoardDimensions().getX() <= MAX && configuration.getBoardDimensions().getY() <= MAX;
    }

    private boolean isRowValid(Configuration configuration){
        return configuration.getBoardDimensions().getX() >= 3 && configuration.getBoardDimensions().getX() >= configuration.getGameSymbolsToWin();
    }

    private boolean isColumnValid(Configuration configuration){
        return configuration.getBoardDimensions().getY() >= 3 && configuration.getBoardDimensions().getY() >= configuration.getGameSymbolsToWin();
    }

}
