package game;

import UI.Language;
import UI.Output;
import board.BoardDimensions;

public class Configuration {
    private BoardDimensions boardDimensions;
    private int gameSymbolsToWin;
    private Language language;
    private Output output;

    public Configuration(BoardDimensions board, int gameSymbolsToWin, Language language, Output output) {
        this.boardDimensions = board;
        this.gameSymbolsToWin = gameSymbolsToWin;
        this.language = language;
        this.output = output;
    }

    public Language getLanguage() {
        return language;
    }

    public Output getOutput() {
        return output;
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
