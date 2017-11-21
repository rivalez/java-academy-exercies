package game;

import UI.BoardPrinter;
import UI.Communicate;
import UI.PositionAsker;
import board.Move;
import board.WinResolver;
import gameHistory.GameProgress;
import player.Player;
import validators.MoveValidator;

import java.util.List;

public class Game {

    private PositionAsker positionAsker = new PositionAsker();
    private MoveValidator moveValidator;
    private BoardPrinter boardPrinter;

    public Game(MoveValidator moveValidator, Configuration configuration){
        this.moveValidator = moveValidator;
        this.boardPrinter = new BoardPrinter(configuration);
    }

    public void start(Turn turn, GameProgress gameProgress, List<WinResolver> resolvers){
        boolean isGameRunning = true;
        Player currentPlayer = null;
        while (isGameRunning) {
            int suggestedPosition = positionAsker.askForPosition();
            if (moveValidator.validate(suggestedPosition)) {
                currentPlayer = turn.getNext();
                System.out.println(String.format("Current player's turn %s with symbol %s",
                        currentPlayer.getName(),
                        currentPlayer.getGameSymbol().name()));
                gameProgress.addMove(new Move(suggestedPosition, currentPlayer.getGameSymbol()));
                System.out.println(boardPrinter.print(gameProgress));
                for(WinResolver resolver : resolvers){
                    if(resolver.resolve(gameProgress)){
                        isGameRunning = false;
                    }
                }
            } else {
                System.out.println("Wrong move dude, you lost turn!");
            }
        }
        new Communicate(String.format("Game finished! %s has won", currentPlayer.getName())).getMessage();
    }




}
