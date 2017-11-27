package UI;

import board.BoardBuilder;
import board.BoardDimensions;
import board.Move;
import game.Configuration;
import gameHistory.GameProgress;

import java.util.List;

public class BoardPrinter {

    private Configuration configuration;
    private BoardBuilder boardBuilder;

    public BoardPrinter(Configuration configuration) {
        this.configuration = configuration;
        this.boardBuilder = new BoardBuilder(configuration);
    }

    public String print(GameProgress gameProgress) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Move> board = boardBuilder.build(gameProgress.getMoves());
        return print(stringBuilder, board);
    }

    public String print() {
        StringBuilder stringBuilder = new StringBuilder();
        List<Move> board = boardBuilder.build();
        return print(stringBuilder, board);
    }

    private String print(StringBuilder stringBuilder, List<Move> board) {
        BoardDimensions dimensions = configuration.getBoardDimensions();
        int counter = 0;
        for(int i = 0 ; i < dimensions.getX(); i++) {
            for(int j = 0; j < dimensions.getY(); j++){
                stringBuilder.append(board.get(counter++)).append(" ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
