package game;

import UI.Communicate;
import board.BoardDimensions;

class ConfigurationValidator {

    private static final int MAX = 100;

    Configuration check(Configuration configuration){
        if(!isValid(configuration)){
            new Communicate("Your configuration was not correct, providing correct one...").getMessage();
            BoardDimensions boardDimensions = new BoardDimensions(3,3);
            return new Configuration(boardDimensions, 3);
        }
        return configuration;
//        Optional

    }

    private boolean isValid(Configuration configuration) {
        return (configuration.getGameSymbolsToWin() >= 1 && isRowValid(configuration))
                && (isColumnValid(configuration) && configuration.getGameSymbolsToWin() >= 1) && isTooBig(configuration);
    }

    private boolean isTooBig(Configuration configuration) {
        return configuration.getBoardDimensions().getX() <= MAX || configuration.getBoardDimensions().getY() <= MAX;
    }

    private boolean isRowValid(Configuration configuration){
        return configuration.getBoardDimensions().getX() >= 1 && configuration.getBoardDimensions().getX() > configuration.getGameSymbolsToWin();
    }

    private boolean isColumnValid(Configuration configuration){
        return configuration.getBoardDimensions().getY() >= 1 && configuration.getBoardDimensions().getY() > configuration.getGameSymbolsToWin();
    }

}
