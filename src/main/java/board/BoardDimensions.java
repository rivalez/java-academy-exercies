package board;

public class BoardDimensions {

    private int x;
    private int y;

    public BoardDimensions(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BoardDimensions boardDimensions = (BoardDimensions) o;

        if (x != boardDimensions.x) return false;
        return y == boardDimensions.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
