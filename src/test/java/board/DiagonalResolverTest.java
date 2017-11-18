package board;

import game.GameState;
import game.GameSymbol;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class DiagonalResolverTest {

    private BoardCreator boardCreator = new BoardCreator();

    @DataProvider
    public Object[][] getData(){
        return new Object[][] {
                {Arrays.asList(new Move(0,GameSymbol.X), new Move(3, GameSymbol.X), new Move(4, GameSymbol.X), new Move(7, GameSymbol.O), new Move(8, GameSymbol.X)), Arrays.asList(
                        new Move(0, GameSymbol.X), new Move(4, GameSymbol.X), new Move(8, GameSymbol.X))},
        };
    }

    @Test(dataProvider = "getData")
    public void shouldFindThreeElementsDiagonal(List<Move> moves, List<Move> expected){
        //given
        GameState gameState = boardCreator.createBoard(moves, new BoardDimensions(3,3));
        DiagonalResolver diagonalResolver = new DiagonalResolver();

        //when
        List<Move> result = diagonalResolver.resolve(0, gameState);

        //then
        Assert.assertEquals(result, expected);
    }

    @Test(dataProvider = "getData")
    public void shouldFindThreeElementsNotStandardBoardDiagonal(List<Move> moves, List<Move> expected){
        //given
        GameState gameState = boardCreator.createBoard(moves, new BoardDimensions(3,3));
        DiagonalResolver diagonalResolver = new DiagonalResolver();

        //when
        List<Move> result = diagonalResolver.resolve(4, gameState);

        //then
        Assert.assertEquals(result, expected);
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
        List<Move> result = diagonalResolver.resolve(8, gameState);

        //then
        Assert.assertEquals(result, Arrays.asList(
                new Move(8, GameSymbol.X), new Move(4, GameSymbol.X), new Move(0, GameSymbol.X)));
    }



}
