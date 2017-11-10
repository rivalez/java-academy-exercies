package board;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BoardTest {

    private FieldProvider fieldProvider;

    @BeforeTest
    public void setUp(){
        fieldProvider = new FieldProvider();
    }

    @Test
    public void createSquareBoard(){
        //given
        BoardDimensions boardDimensions = new BoardDimensions(3,3);

        //when
        GameBoard gameField = fieldProvider.create(boardDimensions);
        
        //then
        Assert.assertNotNull(gameField);
        Assert.assertTrue(gameField.getField() instanceof SquareField);
        Assert.assertEquals(gameField.getDimensions(), boardDimensions);
    }

    @Test
    public void createRectangleBoard(){
        //given
        BoardDimensions boardDimensions = new BoardDimensions(10,7);

        //when
        GameBoard gameField = fieldProvider.create(boardDimensions);

        //then
        Assert.assertNotNull(gameField);
        Assert.assertTrue(gameField.getField() instanceof RectangleField);
        Assert.assertEquals(gameField.getDimensions(), boardDimensions);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void invalidBoard(){
        //given
        BoardDimensions boardDimensions = new BoardDimensions(-2,0);

        //when
        fieldProvider.create(boardDimensions);
    }

}