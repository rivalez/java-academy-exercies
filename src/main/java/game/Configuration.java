package game;

import board.BoardDimensions;

public class Configuration {
    private BoardDimensions boardDimensions;
    private int gameSymbolsToWin;

    public Configuration(BoardDimensions board, int gameSymbolsToWin) {
        this.boardDimensions = board;
        this.gameSymbolsToWin = gameSymbolsToWin;
    }

    public BoardDimensions getBoardDimensions() {
        return boardDimensions;
    }

    public int getGameSymbolsToWin() {
        return gameSymbolsToWin;
    }
}
