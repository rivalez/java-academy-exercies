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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Configuration that = (Configuration) o;

        if (gameSymbolsToWin != that.gameSymbolsToWin) return false;
        return boardDimensions != null ? boardDimensions.equals(that.boardDimensions) : that.boardDimensions == null;
    }

    @Override
    public int hashCode() {
        int result = boardDimensions != null ? boardDimensions.hashCode() : 0;
        result = 31 * result + gameSymbolsToWin;
        return result;
    }
}
