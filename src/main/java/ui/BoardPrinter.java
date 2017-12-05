package ui;

import board.BoardBuilder;
import board.BoardDimensions;
import board.Move;
import game.Configuration;
import gamehistory.GameProgress;

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
                //pretty printer
                counter = prettyPrinter(stringBuilder, board, counter);
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    private int prettyPrinter(StringBuilder stringBuilder, List<Move> board, int counter) {
        if(counter < 10) {
            stringBuilder.append("| ").append(board.get(counter++)).append(" |");
        } else if(counter < 100){
            stringBuilder.append("| ").append(board.get(counter++)).append("|");
        } else {
            stringBuilder.append("|").append(board.get(counter++)).append("|");
        }
        return counter;
    }
}
