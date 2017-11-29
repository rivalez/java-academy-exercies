package game;

import board.BoardDimensions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.CommunicateProvider;
import ui.Language;
import ui.Output;
import ui.SystemPrintOut;

import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.assertEquals;

@Test
public class ConfigurationValidatorTest {

    private Output output = new SystemPrintOut();
    private Language language = Language.ENGLISH;

    @DataProvider
    public Object[][] getConfigInc(){
        return new Object[][] {
                {new Configuration(new BoardDimensions(1,1), 1, language, output)},
                {new Configuration(new BoardDimensions(2,2), 1, language, output)},
                {new Configuration(new BoardDimensions(3,3), 1, language, output)},
                {new Configuration(new BoardDimensions(4,4), 10, language, output)},
                {new Configuration(new BoardDimensions(3,3), 99, language, output)},
                {new Configuration(new BoardDimensions(150,1), 1, language, output)},
                {new Configuration(new BoardDimensions(1,150), 1, language, output)},
                {new Configuration(new BoardDimensions(100,150), 399, language, output)},
                {new Configuration(new BoardDimensions(100,150), 50, language, output)}
        };
    }

    @DataProvider
    public Object[][] getConfigCor(){
        return new Object[][] {
                {new Configuration(new BoardDimensions(4,4), 4, language, output)},
                {new Configuration(new BoardDimensions(5,5), 5, language, output)},
                {new Configuration(new BoardDimensions(10,15), 8, language, output)},
                {new Configuration(new BoardDimensions(30,30), 5, language, output)},
                {new Configuration(new BoardDimensions(80,80), 4, language, output)},
                {new Configuration(new BoardDimensions(10,10), 3, language, output)},
                {new Configuration(new BoardDimensions(6,9), 4, language, output)},
                {new Configuration(new BoardDimensions(9,6), 4, language, output)}
        };
    }

    @Test(dataProvider = "getConfigInc")
    public void checkInvalid(Configuration configuration){
        //given
        CommunicateProvider communicateProvider = new CommunicateProvider().populate(Language.ENGLISH);
        BoardDimensions boardDimensions = new BoardDimensions(3,3);
        Configuration invalidInputConfiguration = new Configuration(boardDimensions, 3, language, output);
        ConfigurationValidator cv = new ConfigurationValidator(communicateProvider, output, language);

        //when-then
        assertEquals(cv.check(configuration), invalidInputConfiguration);
    }


    @Test(dataProvider = "getConfigCor")
    public void checkValid(Configuration configuration){
        //given
        CommunicateProvider communicateProvider = new CommunicateProvider().populate(Language.ENGLISH);
        BoardDimensions boardDimensions = new BoardDimensions(3,3);
        Configuration invalidInputConfiguration = new Configuration(boardDimensions, 3, language, output);
        ConfigurationValidator cv = new ConfigurationValidator(communicateProvider, output, language);

        //when-then
        assertNotEquals(cv.check(configuration), invalidInputConfiguration);
    }
}
