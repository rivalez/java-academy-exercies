package board;

import game.GameState;
import game.GameSymbol;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class DiagonalResolverTest {

    @Test
    public void diagonalResolve(){
        //given
        GameBoard gameBoard = new BoardProvider().create(new BoardDimensions(3,3));
        GameState gameState = new GameState(gameBoard);
        gameState.listCreator();
        gameState.addElement(0, GameSymbol.X);
        gameState.addElement(1, null);
        gameState.addElement(2, null);
        gameState.addElement(3, GameSymbol.X);
        gameState.addElement(4, GameSymbol.X);
        gameState.addElement(5, null);
        gameState.addElement(6, null);
        gameState.addElement(7, GameSymbol.O);
        gameState.addElement(8, GameSymbol.X);
        DiagonalResolver diagonalResolver = new DiagonalResolver();

        //when
        List<Field> result = diagonalResolver.resolve(4, gameState);

        //then
        Assert.assertEquals(result, Arrays.asList(
                new Field(0, GameSymbol.X), new Field(3, GameSymbol.X), new Field(8, GameSymbol.X)));
    }

    @Test
    public void diagonalReverseResolve(){
        //given
        GameBoard gameBoard = new BoardProvider().create(new BoardDimensions(3,3));
        GameState gameState = new GameState(gameBoard);
        gameState.listCreator();
        gameState.addElement(0, GameSymbol.X);
        gameState.addElement(1, null);
        gameState.addElement(2, null);
        gameState.addElement(3, GameSymbol.X);
        gameState.addElement(4, GameSymbol.X);
        gameState.addElement(5, null);
        gameState.addElement(6, null);
        gameState.addElement(7, GameSymbol.O);
        gameState.addElement(8, GameSymbol.X);
        DiagonalResolver diagonalResolver = new DiagonalResolver();

        //when
        List<Field> result = diagonalResolver.resolve(8, gameState);

        //then
        Assert.assertEquals(result, Arrays.asList(
                new Field(0, GameSymbol.X), new Field(3, GameSymbol.X), new Field(8, GameSymbol.X)));
    }



}
