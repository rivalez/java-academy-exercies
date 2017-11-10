package UI;

import board.FieldProvider;
import board.GameBoard;
import board.BoardDimensions;
import game.GameState;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardPrinterTest {

    @Test
    public void boardPrinter(){
        //given
        BoardDimensions boardDimensions = new BoardDimensions(3,4);
        FieldProvider fieldProvider = new FieldProvider();
        GameBoard gameField = fieldProvider.create(boardDimensions);
        GameState gameState = new GameState(gameField);
        gameState.listCreator();
        BoardPrinter boardPrinter = new BoardPrinter(gameState);
        //when
        String result = boardPrinter.print();

        //then
        Assert.assertEquals(result,
                "0123\n" +
                        "4567\n" +
                        "891011\n");
    }
}
