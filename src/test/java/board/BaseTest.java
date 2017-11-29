package board;

import game.Configuration;
import ui.Language;
import ui.Output;
import ui.SystemPrintOut;

abstract class BaseTest {

    private static Output output = new SystemPrintOut();
    private static Language language = Language.ENGLISH;
    static Configuration configuration1 = new Configuration(new BoardDimensions(3,3), 3, language, output);
    static Configuration configuration2 = new Configuration(new BoardDimensions(3,3), 2, language, output);
    static Configuration configuration3 = new Configuration(new BoardDimensions(5,7), 4, language, output);
    static Configuration configuration4 = new Configuration(new BoardDimensions(6,9), 3, language, output);
    static Configuration configuration5 = new Configuration(new BoardDimensions(5,8), 3, language, output);
    static Configuration configuration6 = new Configuration(new BoardDimensions(4,4), 3, language, output);
    static Configuration configuration7 = new Configuration(new BoardDimensions(4,5), 3, language, output);
    static Configuration configuration8 = new Configuration(new BoardDimensions(3,4), 3, language, output);
    static Configuration configuration9 = new Configuration(new BoardDimensions(4,3), 3, language, output);
    static Configuration configuration10 = new Configuration(new BoardDimensions(10,15), 4, language, output);
    static Configuration configurationMAX = new Configuration(new BoardDimensions(100,100), 4, language, output);
    static Configuration configurationMAX2 = new Configuration(new BoardDimensions(99,101), 3, language, output);
    static Configuration configurationRowMax = new Configuration(new BoardDimensions(101,1), 4, language, output);

}
