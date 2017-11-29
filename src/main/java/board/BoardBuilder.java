package board;

import game.Configuration;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by marek on 18.11.2017.
 */
public class BoardBuilder {

    private Configuration configuration;

    public BoardBuilder(Configuration configuration){
        this.configuration = configuration;
    }

    private static Move apply(int c) {
        return new Move(c);
    }

    public List<Move> build(List<Move> moves) {
        if(moves.isEmpty()) {
            return build();
        }
        List<Move> board;
        BoardDimensions boardDimensions = configuration.getBoardDimensions();
        int numberOfFields = boardDimensions.getX() * boardDimensions.getY();
        board = IntStream.range(0, numberOfFields).mapToObj(BoardBuilder::apply).collect(Collectors.toList());
        for (Move move : moves) {
            board.set(move.getPosition(), move);
        }
        return board;
    }

    public List<Move> build(){
        List<Move> board;
        BoardDimensions boardDimensions = configuration.getBoardDimensions();
        int numberOfFields = boardDimensions.getX() * boardDimensions.getY();
        board = IntStream.range(0, numberOfFields).mapToObj(BoardBuilder::apply).collect(Collectors.toList());
        return board;
    }

}
