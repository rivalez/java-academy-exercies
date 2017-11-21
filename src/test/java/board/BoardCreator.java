package board;

import game.Configuration;
import gameHistory.GameProgress;

import java.util.List;

/**
 * @author
 * @since
 */
class BoardCreator {

    GameProgress createGame(List<Move> moves, Configuration configuration){
        GameProgress gameProgress = new GameProgress(configuration);
        for(Move move : moves){
            gameProgress.addMove(move);
        }
        return gameProgress;
    }
}
