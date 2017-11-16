package game;

import board.Move;
import board.GameBoard;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameState {

    private List<Move> board = new ArrayList<Move>();

    private GameBoard gameBoard;

    public GameState(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public void listCreator(){
        int numberOfFields = gameBoard.getDimensions().getX() * gameBoard.getDimensions().getY();
        board = IntStream.range(0, numberOfFields).mapToObj(c-> new Move(c)).collect(Collectors.toList());
    }

    public List<Move> getBoard() {
        return board;
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public void addElement(int position, GameSymbol gameSymbol){
        if(board.get(position).isEmpty()) board.set(position, new Move(position, gameSymbol));
    }

}