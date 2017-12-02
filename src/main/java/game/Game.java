package game;

import board.Move;
import board.WinResolver;
import gamehistory.GameProgress;
import player.Player;
import ui.*;
import validators.MoveValidator;

import java.util.List;

import static game.GameState.*;

public class Game {

    private PlayerInteract interact;
    private Arbiter arbiter = new Arbiter();
    private MoveValidator moveValidator;
    private BoardPrinter boardPrinter;
    private CommunicateProvider communicateProvider;
    private Output output;
    private GameState gameState = NOT_RESOLVED;

    public Game(CommunicateProvider communicateProvider, Configuration configuration, Output output, PlayerInteract interact){
        this.output = output;
        this.interact = interact;
        this.communicateProvider = communicateProvider;
        this.boardPrinter = new BoardPrinter(configuration);
        this.moveValidator = new MoveValidator(configuration.getBoardDimensions().getX() * configuration.getBoardDimensions().getY());
    }

    GameState start(Turn turn, GameProgress gameProgress, List<WinResolver> resolvers) {
        Player currentPlayer = turn.getFirst();
        while (gameState == NOT_RESOLVED) {
                output.display(communicateProvider.getCommunicate(Communicate.CURRENT_PLAYER_TURN) + ": " + currentPlayer.toString());
                output.display(boardPrinter.print(gameProgress));
                int suggestedPosition = interact.askForPosition();
            if (moveValidator.validate(suggestedPosition)) {
                Move next = new Move(suggestedPosition, currentPlayer.getGameSymbol());
                if(!gameProgress.isOccupied(next)){
                    gameProgress.addMove(next);
                } else {
                    output.display(communicateProvider.getCommunicate(Communicate.WRONG_TURN));
                }
                checkForWin(gameProgress, resolvers, currentPlayer);
                checkDraw(turn, gameProgress);
                currentPlayer = turn.getNext();
            } else {
                output.display(communicateProvider.getCommunicate(Communicate.WRONG_TURN));
            }
        }
        return gameState;
    }

    private void checkDraw(Turn turn, GameProgress gameProgress) {
        if(gameProgress.getMoves().size() == gameProgress.getConfiguration().getBoardDimensions().getX() * gameProgress.getConfiguration().getBoardDimensions().getY()) {
            gameState = DRAW;
            arbiter.admitPoints(turn.getPlayers());
            output.display(communicateProvider.getCommunicate(Communicate.DRAW));
        }
    }

    private void checkForWin(GameProgress gameProgress, List<WinResolver> resolvers, Player currentPlayer) {
        for(WinResolver resolver : resolvers) {
            if(resolver.resolve(gameProgress)) {
                gameState = WIN;
                arbiter.admitPoints(currentPlayer);
                output.display(String.format(communicateProvider.getCommunicate(Communicate.FINISH), currentPlayer));
            }
        }
    }

}