package game;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import validators.MoveValidator;

public class MoveValidatorTest {

    @DataProvider
    private Object[][] getData(){
        return new Object[][] {{9,10}, {10,-3}, {3, 13000}};
    }

    @Test(dataProvider = "getData")
    public void validateIncorrect(int boardSize, int position){
        //given
        MoveValidator moveValidator = new MoveValidator(boardSize);

        //when - then
        Assert.assertFalse(moveValidator.validateOutOfBounds(position));
    }

    @Test
    public void validateCorrect(){
        //given
        MoveValidator moveValidator = new MoveValidator(10);

        //when - then
        Assert.assertTrue(moveValidator.validateOutOfBounds(0));
    }

}
