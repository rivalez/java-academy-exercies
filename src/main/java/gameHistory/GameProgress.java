package gameHistory;

import board.Move;
import game.Configuration;

import java.util.ArrayList;
import java.util.LinkedList;
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

    public List<Move> getMoves() {
        return new ArrayList<>(moves);
    }

    public Configuration getConfiguration() {
        return configuration;
    }

}
