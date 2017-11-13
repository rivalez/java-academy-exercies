package board;

import game.GameState;
import game.GameSymbol;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class RowResolverTest {

    @Test
    public void rowResolve(){
        //given
        GameBoard gameBoard = new BoardProvider().create(new BoardDimensions(3,3));
        GameState gameState = new GameState(gameBoard);
        gameState.listCreator();
        gameState.addElement(0, GameSymbol.X);
        gameState.addElement(1, GameSymbol.X);
        gameState.addElement(2, GameSymbol.X);
        gameState.addElement(3, GameSymbol.O);
        gameState.addElement(4, GameSymbol.O);
        gameState.addElement(5, GameSymbol.X);
        RowResolver rowResolver = new RowResolver();

        //when
        List<Field> result = rowResolver.resolve(1, gameState);

        //then
        Assert.assertEquals(result, Arrays.asList(
                new Field(0, GameSymbol.X), new Field(1, GameSymbol.X), new Field(2, GameSymbol.X)));
    }

    @Test
    public void rowResolveIncorrect(){
        //given
        GameBoard gameBoard = new BoardProvider().create(new BoardDimensions(3,3));
        GameState gameState = new GameState(gameBoard);
        gameState.listCreator();
        gameState.addElement(0, GameSymbol.X);
        gameState.addElement(1, GameSymbol.X);
        gameState.addElement(2, GameSymbol.X);
        gameState.addElement(3, GameSymbol.O);
        gameState.addElement(4, GameSymbol.O);
        gameState.addElement(5, GameSymbol.X);
        RowResolver rowResolver = new RowResolver();

        //when
        List<Field> result = rowResolver.resolve(4, gameState);

        //then
        Assert.assertNotEquals(result, Arrays.asList(
                new Field(0, GameSymbol.X), new Field(1, GameSymbol.X), new Field(2, GameSymbol.X)));
    }
}
