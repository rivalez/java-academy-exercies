package game;

import board.BoardDimensions;

public class Configuration {
    private BoardDimensions board;
    private int gameSymbolsToWin;
    private boolean start = true;

    public Configuration(BoardDimensions board, int gameSymbolsToWin) {
        this.board = board;
        this.gameSymbolsToWin = gameSymbolsToWin;
    }

    public boolean isStart() {
        return start;
    }

    public BoardDimensions getBoard() {
        return board;
    }

    public int getGameSymbolsToWin() {
        return gameSymbolsToWin;
    }
}
