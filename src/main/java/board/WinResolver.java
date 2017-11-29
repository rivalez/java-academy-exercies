package board;

import gamehistory.GameProgress;

public interface WinResolver {
    boolean resolve(GameProgress gameProgress);

}
