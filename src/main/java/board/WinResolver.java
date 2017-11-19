package board;

import gameHistory.GameProgress;

public interface WinResolver {
    boolean resolve(GameProgress gameProgress);

}
