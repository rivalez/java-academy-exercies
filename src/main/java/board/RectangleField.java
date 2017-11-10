package board;

public class RectangleField implements GameBoard {

    private BoardDimensions boardDimensions;

    public RectangleField(BoardDimensions boardDimensions) {
        this.boardDimensions = boardDimensions;
    }

    public GameBoard getField() {
        return this;
    }

    public BoardDimensions getDimensions() {
        return boardDimensions;
    }
}
