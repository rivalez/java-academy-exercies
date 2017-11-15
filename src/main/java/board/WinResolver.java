package board;

import game.GameState;

import java.util.List;

public interface WinResolver {
    List<Move> resolve(int suggestedPosition, GameState gameState);

}
