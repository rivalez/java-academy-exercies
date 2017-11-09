package game;

import board.Point2D;

public class Configuration {
    private Point2D board;
    private int gameSymbolsToWin;
    private boolean start = true;

    public Configuration(Point2D board, int gameSymbolsToWin) {
        this.board = board;
        this.gameSymbolsToWin = gameSymbolsToWin;
    }

    public boolean isStart() {
        return start;
    }

    public Point2D getBoard() {
        return board;
    }

    public int getGameSymbolsToWin() {
        return gameSymbolsToWin;
    }
}
