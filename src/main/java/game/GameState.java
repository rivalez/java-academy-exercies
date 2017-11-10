package game;

import board.Field;
import board.GameBoard;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameState {

    private List<Field> board = new ArrayList<Field>();

    private GameBoard gameField;

    public GameState(GameBoard gameField) {
        this.gameField = gameField;
    }

    public void listCreator(){
        int numberOfFields = gameField.getDimensions().getX() * gameField.getDimensions().getY();
        board = IntStream.range(0, numberOfFields).mapToObj(c-> new Field(c)).collect(Collectors.toList());
    }

    public List<Field> getBoard() {
        return board;
    }

    public GameBoard getGameField() {
        return gameField;
    }

    public void addElement(int position, GameSymbol gameSymbol){
        if(board.get(position).isEmpty()) board.set(position, new Field(position, gameSymbol));
    }

}