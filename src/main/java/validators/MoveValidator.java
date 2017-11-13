package validators;

public class MoveValidator {

    private int boardSize;

    public MoveValidator(int boardSize){
        this.boardSize = boardSize;
    }

    public boolean validate(int position) {
        return position <= boardSize && position >= 0;

    }
}
