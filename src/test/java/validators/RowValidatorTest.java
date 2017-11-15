package validators;

import board.BoardDimensions;
import board.Move;
import game.Configuration;
import game.GameSymbol;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class RowValidatorTest {

    private Configuration configuration = new Configuration(new BoardDimensions(3,3), 3);
    private BoardPartValidator boardPartValidator = new BoardPartValidator(configuration);

    @Test
    public void validateXXXRow(){
        //when-then
        Assert.assertTrue(boardPartValidator.validate(Arrays.asList(
                new Move(0, GameSymbol.X),
                new Move(1, GameSymbol.X),
                new Move(2, GameSymbol.X))));
    }

    @Test
    public void validateXOXRowIncorrect(){
        //when-then
        Assert.assertFalse(boardPartValidator.validate(Arrays.asList(
                new Move(0, GameSymbol.X),
                new Move(2, GameSymbol.O),
                new Move(3, GameSymbol.X))));
    }

    @Test
    public void validateXXNXRowIncorrect(){
        //when-then
        Assert.assertFalse(boardPartValidator.validate(Arrays.asList(
                new Move(100, GameSymbol.X),
                new Move(1, GameSymbol.O),
                new Move(2, GameSymbol.X),
                new Move(3, GameSymbol.X))));
    }

    @Test
    public void validateXX0XXRowIncorrect(){
        //when-then
        Assert.assertFalse(boardPartValidator.validate(Arrays.asList(
                new Move(0, GameSymbol.X),
                new Move(1, GameSymbol.X),
                new Move(2, GameSymbol.O),
                new Move(3, GameSymbol.X),
                new Move(4, GameSymbol.X))));
    }

    @Test
    public void validateOOOOXRow(){
        //when-then
        Assert.assertTrue(boardPartValidator.validate(Arrays.asList(
                new Move(0, GameSymbol.O),
                new Move(1, GameSymbol.O),
                new Move(2, GameSymbol.O),
                new Move(3, GameSymbol.O),
                new Move(4, GameSymbol.X))));
    }
}