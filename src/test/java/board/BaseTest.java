package board;

import game.Configuration;

abstract class BaseTest {
    static Configuration configuration1 = new Configuration(new BoardDimensions(3,3), 3);
    static Configuration configuration2 = new Configuration(new BoardDimensions(3,3), 2);
    static Configuration configuration3 = new Configuration(new BoardDimensions(5,7), 4);
    static Configuration configuration4 = new Configuration(new BoardDimensions(6,9), 3);
    static Configuration configuration5 = new Configuration(new BoardDimensions(5,8), 3);

}
