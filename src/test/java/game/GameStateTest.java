package game;

import board.Field;
import board.FieldProvider;
import board.GameField;
import board.Point2D;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GameStateTest {

    private GameState gameState;

    @Test
    public void createEmptyGameListTest(){
        FieldProvider fieldProvider = new FieldProvider();
        Point2D board = new Point2D(3,3);
        GameField gameField = fieldProvider.create(board);
        gameState = new GameState(gameField);
        //when
        gameState.listCreator();
        //then
        Assert.assertEquals(gameState.getBoard().size(), 9);
        Assert.assertEquals(gameState.getBoard().get(0), new Field());
        Assert.assertTrue(gameState.getBoard().get(0).isEmpty());
    }

    @Test
    public void createGameListAndPopulateItTest(){
        FieldProvider fieldProvider = new FieldProvider();
        Point2D board = new Point2D(3,3);
        GameField gameField = fieldProvider.create(board);
        gameState = new GameState(gameField);
        //when
        gameState.listCreator();
        gameState.addElement(0, GameSymbol.O);
        gameState.addElement(1, GameSymbol.X);

        //then
        Assert.assertEquals(gameState.getBoard().size(), 9);
        Assert.assertEquals(gameState.getBoard().get(0), new Field(GameSymbol.O));
        Assert.assertEquals(gameState.getBoard().get(1), new Field(GameSymbol.X));
        Assert.assertFalse(gameState.getBoard().get(0).isEmpty());
        Assert.assertFalse(gameState.getBoard().get(1).isEmpty());
    }
}