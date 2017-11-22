package board;

import game.Configuration;

abstract class BaseTest {
    static Configuration configuration1 = new Configuration(new BoardDimensions(3,3), 3);
    static Configuration configuration2 = new Configuration(new BoardDimensions(3,3), 2);
    static Configuration configuration3 = new Configuration(new BoardDimensions(5,7), 4);
    static Configuration configuration4 = new Configuration(new BoardDimensions(6,9), 3);
    static Configuration configuration5 = new Configuration(new BoardDimensions(5,8), 3);
    static Configuration configuration6 = new Configuration(new BoardDimensions(4,4), 3);
    static Configuration configuration7 = new Configuration(new BoardDimensions(4,5), 3);
    static Configuration configurationMAX = new Configuration(new BoardDimensions(100,100), 4);
    static Configuration configurationMAX2 = new Configuration(new BoardDimensions(99,101), 3);
    static Configuration configurationRowMax = new Configuration(new BoardDimensions(101,1), 4);

}
