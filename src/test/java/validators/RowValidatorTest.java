package validators;

import board.BoardDimensions;
import board.Field;
import game.Configuration;
import game.GameSymbol;
import org.testng.Assert;
import org.testng.annotations.Test;
import sun.plugin2.message.GetAuthenticationReplyMessage;

import java.util.Arrays;

public class RowValidatorTest {


    private Configuration configuration = new Configuration(new BoardDimensions(3,3), 3);
    private RowValidator rowValidator = new RowValidator(configuration);

    @Test
    public void validateXXXRow(){
        //when-then
        Assert.assertTrue(rowValidator.validate(Arrays.asList(
                new Field(1, GameSymbol.X),
                new Field(2, GameSymbol.X),
                new Field(3, GameSymbol.X))));
    }

    @Test
    public void validateXOXRowIncorrect(){
        //when-then
        Assert.assertFalse(rowValidator.validate(Arrays.asList(
                new Field(0, GameSymbol.X),
                new Field(2, GameSymbol.O),
                new Field(3, GameSymbol.X))));
    }

    @Test
    public void validateXXNXRowIncorrect(){
        //when-then
        Assert.assertFalse(rowValidator.validate(Arrays.asList(
                new Field(100, GameSymbol.X),
                new Field(),
                new Field(2, GameSymbol.X),
                new Field(3, GameSymbol.X))));
    }

    @Test
    public void validateXX0XXRowIncorrect(){
        //when-then
        Assert.assertFalse(rowValidator.validate(Arrays.asList(
                new Field(0, GameSymbol.X),
                new Field(1, GameSymbol.X),
                new Field(2, GameSymbol.O),
                new Field(3, GameSymbol.X),
                new Field(4, GameSymbol.X))));
    }

    @Test
    public void validateOOOOXRow(){
        //when-then
        Assert.assertTrue(rowValidator.validate(Arrays.asList(
                new Field(0, GameSymbol.O),
                new Field(1, GameSymbol.O),
                new Field(2, GameSymbol.O),
                new Field(3, GameSymbol.O),
                new Field(4, GameSymbol.X))));
    }
}