package game;

import board.Move;
import board.BoardProvider;
import board.GameBoard;
import board.BoardDimensions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class GameStateTest {

    private GameState gameState;

    @Test
    public void createEmptyGameList(){
        BoardProvider fieldProvider = new BoardProvider();
        BoardDimensions board = new BoardDimensions(3,3);
        GameBoard gameField = fieldProvider.create(board);
        gameState = new GameState(gameField);
        //when
        gameState.listCreator();
        //then
        Assert.assertEquals(gameState.getBoard().size(), 9);
        Assert.assertEquals(gameState.getBoard().get(0), new Move());
        Assert.assertTrue(gameState.getBoard().get(0).isEmpty());
    }

    @Test
    public void createGameListAndPopulateIt(){
        BoardProvider fieldProvider = new BoardProvider();
        BoardDimensions board = new BoardDimensions(3,3);
        GameBoard gameField = fieldProvider.create(board);
        gameState = new GameState(gameField);
        //when
        gameState.listCreator();
        gameState.addElement(0, GameSymbol.O);
        gameState.addElement(1, GameSymbol.X);

        //then
        Assert.assertEquals(gameState.getBoard().size(), 9);
        Assert.assertEquals(gameState.getBoard().get(0), new Move(0,GameSymbol.O));
        Assert.assertEquals(gameState.getBoard().get(1), new Move(1,GameSymbol.X));
        Assert.assertFalse(gameState.getBoard().get(0).isEmpty());
        Assert.assertFalse(gameState.getBoard().get(1).isEmpty());
    }
}