package board;

public class FieldProvider  {

    private FieldValidator fieldValidator = new FieldValidator();
    private Point2D point2D;

    public GameField create(Point2D point2D) {
        return provideField(point2D);
    }

    private GameField provideField(Point2D point2D){
        GameField gameField;
        if(point2D.getX() <= 2 || point2D.getY() <= 2) throw new IllegalArgumentException();
        else if(point2D.getX() == point2D.getY()){
            gameField = new SquareField(point2D);
        } else {
            gameField = new RectangleField(point2D);
        }
        return gameField;
    }

    public Point2D getDimensions() {
        return point2D;
    }
}
