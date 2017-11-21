package game;

import UI.Communicate;
import board.BoardDimensions;

class ConfigurationValidator {

    Configuration check(Configuration configuration){
        if(isValid(configuration)){
            new Communicate("Your configuration was not correct, providing correct one...").getMessage();
            BoardDimensions boardDimensions = new BoardDimensions(3,3);
            return new Configuration(boardDimensions, 3);
        }
        return configuration;
//        Optional

    }

    private boolean isValid(Configuration configuration) {
        return configuration.getGameSymbolsToWin() <= 1
                || configuration.getBoardDimensions().getX() <= 2
                || configuration.getBoardDimensions().getY() <= 2
                || configuration.getBoardDimensions().getX() < configuration.getGameSymbolsToWin()
                || configuration.getBoardDimensions().getY() < configuration.getGameSymbolsToWin();
    }

}
