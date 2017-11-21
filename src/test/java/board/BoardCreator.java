package board;

import game.Configuration;
import game.GameState;
import gameHistory.GameProgress;

import java.util.List;

/**
 * Created by marek on 18.11.2017.
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
