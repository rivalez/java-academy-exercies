package board;

public class RectangleField implements GameField {

    private Point2D point2D;

    public RectangleField(Point2D point2D) {
        this.point2D = point2D;
    }

    public GameField getField() {
        return this;
    }

    public Point2D getDimensions() {
        return point2D;
    }
}
