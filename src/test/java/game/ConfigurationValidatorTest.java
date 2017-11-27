package game;

import UI.CommunicateProvider;
import UI.Language;
import UI.Output;
import UI.SystemPrintOut;
import board.BoardDimensions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.assertEquals;

@Test
public class ConfigurationValidatorTest {

    private Output output = new SystemPrintOut();

    @DataProvider
    public Object[][] getConfigInc(){
        return new Object[][] {
                {new Configuration(new BoardDimensions(1,1), 1)},
                {new Configuration(new BoardDimensions(2,2), 1)},
                {new Configuration(new BoardDimensions(3,3), 1)},
                {new Configuration(new BoardDimensions(4,4), 10)},
                {new Configuration(new BoardDimensions(3,3), 99)},
                {new Configuration(new BoardDimensions(150,1), 1)},
                {new Configuration(new BoardDimensions(1,150), 1)},
                {new Configuration(new BoardDimensions(100,150), 399)},
                {new Configuration(new BoardDimensions(100,150), 50)}
        };
    }

    @DataProvider
    public Object[][] getConfigCor(){
        return new Object[][] {
                {new Configuration(new BoardDimensions(4,4), 4)},
                {new Configuration(new BoardDimensions(5,5), 5)},
                {new Configuration(new BoardDimensions(10,15), 8)},
                {new Configuration(new BoardDimensions(30,30), 5)},
                {new Configuration(new BoardDimensions(80,80), 4)},
                {new Configuration(new BoardDimensions(10,10), 3)},
                {new Configuration(new BoardDimensions(6,9), 4)},
                {new Configuration(new BoardDimensions(9,6), 4)}
        };
    }

    @Test(dataProvider = "getConfigInc")
    public void checkInvalid(Configuration configuration){
        //given
        CommunicateProvider communicateProvider = new CommunicateProvider().populate(Language.ENGLISH);
        BoardDimensions boardDimensions = new BoardDimensions(3,3);
        Configuration invalidInputConfiguration = new Configuration(boardDimensions, 3);
        ConfigurationValidator cv = new ConfigurationValidator(communicateProvider, output);

        //when-then
        assertEquals(cv.check(configuration), invalidInputConfiguration);
    }


    @Test(dataProvider = "getConfigCor")
    public void checkValid(Configuration configuration){
        //given
        CommunicateProvider communicateProvider = new CommunicateProvider().populate(Language.ENGLISH);
        BoardDimensions boardDimensions = new BoardDimensions(3,3);
        Configuration invalidInputConfiguration = new Configuration(boardDimensions, 3);
        ConfigurationValidator cv = new ConfigurationValidator(communicateProvider, output);

        //when-then
        assertNotEquals(cv.check(configuration), invalidInputConfiguration);
    }
}
