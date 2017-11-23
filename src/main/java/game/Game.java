package game;

import UI.BoardPrinter;
import UI.Communicate;
import UI.PlayerInteract;
import board.Move;
import board.WinResolver;
import gameHistory.GameProgress;
import player.Player;
import validators.MoveValidator;

import java.util.List;

import static game.GameState.DRAW;
import static game.GameState.NOT_RESOLVED;
import static game.GameState.WIN;

public class Game {

    private PlayerInteract interact = new PlayerInteract();
    private Arbiter arbiter = new Arbiter();
    private MoveValidator moveValidator;
    private BoardPrinter boardPrinter;

    public Game(MoveValidator moveValidator, Configuration configuration){
        this.moveValidator = moveValidator;
        this.boardPrinter = new BoardPrinter(configuration);
    }

    void start(Turn turn, GameProgress gameProgress, List<WinResolver> resolvers){
        Player currentPlayer = null;
        GameState gameState = NOT_RESOLVED;
        int movesAlreadyDone = 0;
        while (gameState == NOT_RESOLVED) {
            int suggestedPosition = interact.askForPosition();
            if (moveValidator.validate(suggestedPosition)) {
                movesAlreadyDone++;
                currentPlayer = turn.getNext();
                new Communicate(String.format("Current player's turn %s", currentPlayer.toString())).getMessage();
                gameProgress.addMove(new Move(suggestedPosition, currentPlayer.getGameSymbol()));
                new Communicate(boardPrinter.print(gameProgress)).getMessage();
                for(WinResolver resolver : resolvers){
                    if(resolver.resolve(gameProgress)){
                        gameState = WIN;
                        arbiter.admitPoints(currentPlayer);
                    }
                }
                if(movesAlreadyDone == gameProgress.getConfiguration().getBoardDimensions().getX() * gameProgress.getConfiguration().getBoardDimensions().getY()){
                    gameState = DRAW;
                    arbiter.admitPoints(turn.getPlayers());
                }
            } else {
                new Communicate("Wrong move dude, you lost turn!").getMessage();
            }
        }
        new Communicate(String.format("Game finished! %s has won", currentPlayer.toString())).getMessage();
    }
}