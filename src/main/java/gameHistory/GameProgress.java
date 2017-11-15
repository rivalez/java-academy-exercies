package gameHistory;

import board.Move;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GameProgress {

    private List<Move> moves = new LinkedList<>();

    public void addMove(Move move){
        moves.add(move);
    }

    public List<Move> getMoves() {
        return new ArrayList<>(moves);
    }
}
