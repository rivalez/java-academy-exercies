package game;

import board.BoardDimensions;

public class ConfiguratorChecker {

    public Configuration check(Configuration configuration){
        if(configuration.getGameSymbolsToWin() <= 1 || configuration.getBoardDimensions().getX() <= 2 || configuration.getBoardDimensions().getY() <= 2){
            new Communicate("Your configuration was not correct, providing correct one...").getMessage();
            BoardDimensions boardDimensions = new BoardDimensions(3,3);
            return new Configuration(boardDimensions, 3);
        }
        return configuration;

    }

}
