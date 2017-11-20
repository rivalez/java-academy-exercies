package game;

import board.BoardDimensions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

@Test
public class SequenceTest {

    public void sequenceRow(){
        //given
        Sequence sequence = new Sequence(new Configuration(new BoardDimensions(3,3), 3));
        //when
        WinSequence winSequence = sequence.createRowSequence(4);

        //then
        Assert.assertEquals(winSequence.getPositions(), Arrays.asList(4,5,6));
    }
}
