package game;

import UI.*;
import board.Move;
import board.WinResolver;
import gameHistory.GameProgress;
import player.Player;
import validators.MoveValidator;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import static game.GameState.DRAW;
import static game.GameState.NOT_RESOLVED;
import static game.GameState.WIN;

public class Game implements KeyListener{

    private PlayerInteract interact;
    private Arbiter arbiter = new Arbiter();
    private MoveValidator moveValidator;
    private BoardPrinter boardPrinter;
    private CommunicateProvider communicateProvider;
    private Output output;
    private GameState gameState = NOT_RESOLVED;

    public Game(CommunicateProvider communicateProvider, Configuration configuration, Output output){
        this.output = output;
        this.interact = new PlayerInteract(communicateProvider, output);
        this.communicateProvider = communicateProvider;
        this.boardPrinter = new BoardPrinter(configuration);
        this.moveValidator = new MoveValidator(configuration.getBoardDimensions().getX() * configuration.getBoardDimensions().getY());
    }

    void start(Turn turn, GameProgress gameProgress, List<WinResolver> resolvers){
        Player currentPlayer = null;
        int movesAlreadyDone = 0;
        while (gameState == NOT_RESOLVED) {
            int suggestedPosition = interact.askForPosition();
            if (moveValidator.validate(suggestedPosition)) {
                movesAlreadyDone++;
                currentPlayer = turn.getNext();
                output.display(communicateProvider.getCommunicate(Communicate.CURRENT_PLAYER_TURN) + ": " + currentPlayer.toString());
                gameProgress.addMove(new Move(suggestedPosition, currentPlayer.getGameSymbol()));
                output.display(boardPrinter.print(gameProgress));
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
                output.display(communicateProvider.getCommunicate(Communicate.WRONG_TURN));
            }
        }
            output.display(communicateProvider.getCommunicate(Communicate.FINISH) + currentPlayer.toString());
    }

    public GameState getGameState() {
        return gameState;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == '-'){
            System.exit(0);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}