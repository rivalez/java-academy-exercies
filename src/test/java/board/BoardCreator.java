package board;

import game.Configuration;
import game.GameState;
import gameHistory.GameProgress;

import java.util.List;

/**
 * Created by marek on 18.11.2017.
 */
public class BoardCreator {

    protected GameState createBoard(List<Move> moves, BoardDimensions boardDimensions){
        GameBoard gameBoard = new BoardProvider().create(boardDimensions);
        GameState gameState = new GameState(gameBoard);
        gameState.listCreator();
        for(Move move : moves){
            gameState.addElement(move.getPosition(), move.getGameSymbol());
        }

        return gameState;
    }

    protected GameProgress createGame(List<Move> moves, Configuration configuration){
        GameProgress gameProgress = new GameProgress(configuration);
        for(Move move : moves){
            gameProgress.addMove(move);
        }
        return gameProgress;
    }
}
