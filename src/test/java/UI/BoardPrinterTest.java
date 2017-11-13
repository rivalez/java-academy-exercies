package UI;

import board.BoardProvider;
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
        BoardProvider fieldProvider = new BoardProvider();
        GameBoard gameField = fieldProvider.create(boardDimensions);
        GameState gameState = new GameState(gameField);
        gameState.listCreator();
        BoardPrinter boardPrinter = new BoardPrinter(gameState);
        //when
        String result = boardPrinter.print();

        //then
        Assert.assertEquals(result,
                "0 1 2 3 \n" +
                        "4 5 6 7 \n" +
                        "8 9 10 11 \n");
    }
}
