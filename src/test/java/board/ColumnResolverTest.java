package board;

import game.GameState;
import game.GameSymbol;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class ColumnResolverTest {

    @Test
    public void columnResolve(){
        //given
        GameBoard gameBoard = new BoardProvider().create(new BoardDimensions(3,3));
        GameState gameState = new GameState(gameBoard);
        gameState.listCreator();
        gameState.addElement(0, GameSymbol.X);
        gameState.addElement(1, GameSymbol.O);
        gameState.addElement(2, GameSymbol.O);
        gameState.addElement(3, GameSymbol.X);
        gameState.addElement(4, GameSymbol.O);
        gameState.addElement(5, GameSymbol.O);
        gameState.addElement(6, GameSymbol.X);
        ColumnResolver columnResolver = new ColumnResolver();

        //when
        List<Field> result = columnResolver.resolve(0, gameState);

        //then
        Assert.assertEquals(result, Arrays.asList(
                new Field(0, GameSymbol.X), new Field(3, GameSymbol.X), new Field(6, GameSymbol.X)));
    }


    @Test
    public void columnXXXResolve(){
        //given
        GameBoard gameBoard = new BoardProvider().create(new BoardDimensions(3,3));
        GameState gameState = new GameState(gameBoard);
        gameState.listCreator();
        gameState.addElement(0, GameSymbol.X);
        gameState.addElement(1, GameSymbol.O);
        gameState.addElement(2, GameSymbol.O);
        gameState.addElement(3, GameSymbol.X);
        gameState.addElement(4, GameSymbol.O);
        gameState.addElement(5, GameSymbol.O);
        gameState.addElement(6, GameSymbol.X);
        ColumnResolver columnResolver = new ColumnResolver();

        //when
        List<Field> result = columnResolver.resolve(6, gameState);

        //then
        Assert.assertEquals(result, Arrays.asList(
                new Field(0, GameSymbol.X), new Field(3, GameSymbol.X), new Field(6, GameSymbol.X)));
    }

    @Test
    public void columnOOOResolve(){
        //given
        GameBoard gameBoard = new BoardProvider().create(new BoardDimensions(3,3));
        GameState gameState = new GameState(gameBoard);
        gameState.listCreator();
        gameState.addElement(0, null);
        gameState.addElement(1, null);
        gameState.addElement(2, GameSymbol.O);
        gameState.addElement(3, GameSymbol.X);
        gameState.addElement(4, null);
        gameState.addElement(5, GameSymbol.O);
        gameState.addElement(6, GameSymbol.X);
        gameState.addElement(7, GameSymbol.O);
        gameState.addElement(8, GameSymbol.O);
        ColumnResolver columnResolver = new ColumnResolver();

        //when
        List<Field> result = columnResolver.resolve(2, gameState);

        //then
        Assert.assertEquals(result, Arrays.asList(
                new Field(2, GameSymbol.O), new Field(5, GameSymbol.O), new Field(8, GameSymbol.O)));

    }

}
