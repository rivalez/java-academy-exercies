package UI;

import board.FieldProvider;
import board.GameField;
import board.Point2D;
import game.GameState;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardPrinterTest {

    @Test
    public void BoardPrinterTest(){
        //given
        Point2D point2D = new Point2D(3,4);
        FieldProvider fieldProvider = new FieldProvider();
        GameField gameField = fieldProvider.create(point2D);
        GameState gameState = new GameState(gameField);
        gameState.listCreator();
        BoardPrinter boardPrinter = new BoardPrinter(gameState);
        //when
        String result = boardPrinter.print();

        //then
        Assert.assertEquals(result, "....\n" +
                "....\n" +
                "....\n");
    }
}
