package gameHistory;

import board.Move;
import game.Configuration;

import java.util.ArrayList;
import java.util.List;

public class GameProgress {

    private Configuration configuration;

    private List<Move> moves = new ArrayList<>();

    public GameProgress(Configuration configuration) {
        this.configuration = configuration;
    }

    public void addMove(Move move){
        moves.add(move);
    }

    public boolean isOccupied(Move move){
        return moves.contains(move);
    }

    public List<Move> getMoves() {
        return new ArrayList<>(moves);
    }

    public Move getLast() {
        return moves.get(moves.size() - 1);
    }

    public Configuration getConfiguration() {
        return configuration;
    }

}
