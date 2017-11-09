package game;

import board.Field;
import board.GameField;

import java.util.ArrayList;
import java.util.List;

public class GameState {

    private List<Field> board = new ArrayList<Field>();

    private GameField gameField;

    public GameState(GameField gameField) {
        this.gameField = gameField;
    }

    public void listCreator(){
        int numberOfFields = gameField.getDimensions().getX() * gameField.getDimensions().getY();
        List<Field> fields = new ArrayList<Field>();
        for(int i = 0 ; i < numberOfFields; i++){
            fields.add(new Field());
        }
        board.addAll(fields);
    }

    public List<Field> getBoard() {
        return board;
    }

    public GameField getGameField() {
        return gameField;
    }

    public void addElement(int position, GameSymbol gameSymbol){
        if(board.get(position).isEmpty()) board.set(position, new Field(gameSymbol));
    }

}