package game;

import board.BoardDimensions;

public class Configuration {
    private BoardDimensions boardDimensions;
    private int gameSymbolsToWin;
    private boolean start = true;

    public Configuration(BoardDimensions board, int gameSymbolsToWin) {
        this.boardDimensions = board;
        this.gameSymbolsToWin = gameSymbolsToWin;
    }

    public boolean isStart() {
        return start;
    }

    public BoardDimensions getBoardDimensions() {
        return boardDimensions;
    }

    public int getGameSymbolsToWin() {
        return gameSymbolsToWin;
    }
}
