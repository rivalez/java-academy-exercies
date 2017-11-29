package board;

import game.Configuration;
import gamehistory.GameProgress;

import java.util.List;

class BoardCreator {

    GameProgress createGame(List<Move> moves, Configuration configuration){
        GameProgress gameProgress = new GameProgress(configuration);
        for(Move move : moves){
            gameProgress.addMove(move);
        }
        return gameProgress;
    }
}
