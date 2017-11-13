package game;

import validators.MoveValidator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MoveValidatorTest {

    @DataProvider
    private Object[][] getData(){
        return new Object[][] {{9,10}, {10,-3}};
    }

    @Test(dataProvider = "getData")
    public void validateIncorrect(int boardSize, int position){
        //given
        MoveValidator moveValidator = new MoveValidator(boardSize);

        //when - then
        Assert.assertFalse(moveValidator.validate(position));
    }

    @Test
    public void validateCorrect(){
        //given
        MoveValidator moveValidator = new MoveValidator(10);

        //when - then
        Assert.assertTrue(moveValidator.validate(0));
    }

}
