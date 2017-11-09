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
        Point2D point2D = new Point2D(3,3);

        //when
        GameField gameField = fieldProvider.create(point2D);

        //then
        Assert.assertNotNull(gameField);
        Assert.assertTrue(gameField.getField() instanceof SquareField);
        Assert.assertEquals(gameField.getDimensions(), point2D);
    }

    @Test
    public void createRectangleBoard(){
        //given
        Point2D point2D = new Point2D(10,7);

        //when
        GameField gameField = fieldProvider.create(point2D);

        //then
        Assert.assertNotNull(gameField);
        Assert.assertTrue(gameField.getField() instanceof RectangleField);
        Assert.assertEquals(gameField.getDimensions(), point2D);
    }

    @Test
    public void invalidBoard(){
        //given
        Point2D point2D = new Point2D(-2,0);

        //when
        GameField gameField = fieldProvider.create(point2D);

        //then
        Assert.assertNull(gameField);
    }

}