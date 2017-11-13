package validators;

import board.Field;
import game.GameSymbol;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class RowValidatorTest {

    private RowValidator rowValidator = new RowValidator();

    @Test
    public void validateXXXRow(){
        //when-then
        Assert.assertTrue(rowValidator.validate(Arrays.asList(
                new Field(1, GameSymbol.X),new Field(2, GameSymbol.X),new Field(3, GameSymbol.X))));
    }

    @Test
    public void validateXOXRowIncorrect(){
        //when-then
        Assert.assertFalse(rowValidator.validate(Arrays.asList(
                new Field(0, GameSymbol.X),new Field(2, GameSymbol.O),new Field(3, GameSymbol.X))));
    }

    @Test
    public void validateXXOXRowIncorrect(){
        //when-then
        Assert.assertFalse(rowValidator.validate(Arrays.asList(
                new Field(100, GameSymbol.X), new Field(), new Field(2, GameSymbol.X),new Field(3, GameSymbol.X))));
    }

}