package board;

public class FieldProvider  {

    public GameBoard create(BoardDimensions boardDimensions) {
        return provideField(boardDimensions);
    }

    private GameBoard provideField(BoardDimensions boardDimensions){
        GameBoard gameField;
        if(boardDimensions.getX() <= 2 || boardDimensions.getY() <= 2) throw new IllegalArgumentException();
        else if(boardDimensions.getX() == boardDimensions.getY()){
            gameField = new SquareField(boardDimensions);
        } else {
            gameField = new RectangleField(boardDimensions);
        }
        return gameField;
    }
}
