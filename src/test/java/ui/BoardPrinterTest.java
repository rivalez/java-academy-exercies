package ui;

import board.BoardDimensions;
import game.Configuration;
import gamehistory.GameProgress;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardPrinterTest {

    private Output output = new SystemPrintOut();
    private Language language = Language.ENGLISH;

    @Test
    public void boardPrinter(){
        //given
        BoardDimensions boardDimensions = new BoardDimensions(3,4);
        Configuration configuration = new Configuration(boardDimensions, 3, language, output);
        GameProgress gameProgress = new GameProgress(configuration);
        BoardPrinter boardPrinter = new BoardPrinter(configuration);
        //when
        String result = boardPrinter.print(gameProgress);

        //then
        Assert.assertEquals(result,
                "| 0 || 1 || 2 || 3 |\n" +
                "| 4 || 5 || 6 || 7 |\n" +
                "| 8 || 9 || 10|| 11|\n");
    }
}
