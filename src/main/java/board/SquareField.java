package board;

public class SquareField implements GameBoard {

    private BoardDimensions boardDimensions;

    SquareField(BoardDimensions boardDimensions){
        this.boardDimensions = boardDimensions;
    }

    public GameBoard getField() {
        return this;
    }

    public BoardDimensions getDimensions() {
        return boardDimensions;
    }
}
