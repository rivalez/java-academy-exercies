package game;

import board.FieldProvider;
import board.MoveValidator;
import board.Point2D;
import org.testng.annotations.Test;

public class MoveValidatorTest {

    @Test
    public void validateTest(){
        //given
        FieldProvider fieldProvider = new FieldProvider();
        GameState gameState = new GameState(fieldProvider.create(new Point2D(3,3)));
        MoveValidator moveValidator = new MoveValidator();
        //when
        moveValidator.validate(gameState);
        //then
    }
}
