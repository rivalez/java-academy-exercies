package board;

import game.Configuration;
import game.GameSymbol;
import org.testng.annotations.DataProvider;

import java.util.Arrays;
import java.util.List;

/**
 * Created by marek on 19.11.2017.
 */
public class ColumnData {

    private List<Move> simpleCase1 = Arrays.asList(
            new Move(0, GameSymbol.X),
            new Move(3, GameSymbol.X),
            new Move(6, GameSymbol.X));

    private List<Move> simpleCase2 = Arrays.asList(
            new Move(0, GameSymbol.X),
            new Move(3, GameSymbol.X),
            new Move(4, GameSymbol.O),
            new Move(7, GameSymbol.O),
            new Move(6, GameSymbol.X));

    private List<Move> simpleCase3 = Arrays.asList(
            new Move(0, GameSymbol.O),
            new Move(7, GameSymbol.X),
            new Move(6, GameSymbol.O),
            new Move(2, GameSymbol.O),
            new Move(3, GameSymbol.O),
            new Move(4, GameSymbol.X),
            new Move(5, GameSymbol.O),
            new Move(1, GameSymbol.X)
    );

    private List<Move> advancedCase1 = Arrays.asList(
            new Move(0, GameSymbol.O),
            new Move(30, GameSymbol.X),
            new Move(14, GameSymbol.X),
            new Move(7, GameSymbol.X),
            new Move(10, GameSymbol.O),
            new Move(13, GameSymbol.X),
            new Move(2, GameSymbol.X),
            new Move(15, GameSymbol.O),
            new Move(20, GameSymbol.X),
            new Move(21, GameSymbol.X),
            new Move(5, GameSymbol.O)
    );

    private List<Move> advancedCase2 = Arrays.asList(
            new Move(5, GameSymbol.O),
            new Move(30, GameSymbol.X),
            new Move(14, GameSymbol.X),
            new Move(31, GameSymbol.X),
            new Move(32, GameSymbol.X),
            new Move(7, GameSymbol.X),
            new Move(10, GameSymbol.O),
            new Move(13, GameSymbol.X),
            new Move(14, GameSymbol.X),
            new Move(16, GameSymbol.X),
            new Move(2, GameSymbol.X),
            new Move(15, GameSymbol.O),
            new Move(21, GameSymbol.X),
            new Move(22, GameSymbol.X),
            new Move(23, GameSymbol.X),
            new Move(24, GameSymbol.X),
            new Move(20, GameSymbol.O)
    );

    private List<Move> advancedCase3 = Arrays.asList(
            new Move(8, GameSymbol.O),
            new Move(30, GameSymbol.X),
            new Move(14, GameSymbol.X),
            new Move(31, GameSymbol.X),
            new Move(32, GameSymbol.X),
            new Move(7, GameSymbol.X),
            new Move(14, GameSymbol.O),
            new Move(13, GameSymbol.X),
            new Move(14, GameSymbol.X),
            new Move(16, GameSymbol.X),
            new Move(2, GameSymbol.X),
            new Move(20, GameSymbol.O),
            new Move(22, GameSymbol.O),
            new Move(23, GameSymbol.O),
            new Move(21, GameSymbol.X),
            new Move(22, GameSymbol.X),
            new Move(23, GameSymbol.X),
            new Move(24, GameSymbol.X),
            new Move(40, GameSymbol.O),
            new Move(41, GameSymbol.O),
            new Move(42, GameSymbol.O),
            new Move(43, GameSymbol.O),
            new Move(26, GameSymbol.O)
    );

    private List<Move> simpleWrongCase1 = Arrays.asList(
            new Move(0, GameSymbol.O),
            new Move(1, GameSymbol.O),
            new Move(2, GameSymbol.O)
    );

    private List<Move> simpleWrongCase2 = Arrays.asList(
            new Move(5, GameSymbol.O),
            new Move(4, GameSymbol.O),
            new Move(3, GameSymbol.O)
    );

    private List<Move> simpleWrongCase3 = Arrays.asList(
            new Move(5, GameSymbol.O),
            new Move(4, GameSymbol.O),
            new Move(3, GameSymbol.O),
            new Move(0, GameSymbol.X),
            new Move(6, GameSymbol.O),
            new Move(2, GameSymbol.X),
            new Move(1, GameSymbol.X),
            new Move(7, GameSymbol.X),
            new Move(8, GameSymbol.X)
    );


    private List<Move> advancedWrongCase1 = Arrays.asList(
            new Move(5, GameSymbol.O),
            new Move(4, GameSymbol.O),
            new Move(3, GameSymbol.O),
            new Move(0, GameSymbol.X),
            new Move(6, GameSymbol.O),
            new Move(2, GameSymbol.X),
            new Move(1, GameSymbol.X),
            new Move(7, GameSymbol.X),
            new Move(8, GameSymbol.X)
    );

    private List<Move> advancedWrongCase2 = Arrays.asList(
            new Move(0, GameSymbol.O),
            new Move(30, GameSymbol.X),
            new Move(14, GameSymbol.X),
            new Move(7, GameSymbol.X),
            new Move(10, GameSymbol.X),
            new Move(13, GameSymbol.X),
            new Move(2, GameSymbol.X),
            new Move(15, GameSymbol.O),
            new Move(20, GameSymbol.X),
            new Move(21, GameSymbol.X),
            new Move(5, GameSymbol.O)
    );

    private List<Move> advancedWrongCase3 = Arrays.asList(
            new Move(0, GameSymbol.O),
            new Move(1, GameSymbol.O),
            new Move(2, GameSymbol.O),
            new Move(30, GameSymbol.X),
            new Move(14, GameSymbol.X),
            new Move(7, GameSymbol.X),
            new Move(10, GameSymbol.X),
            new Move(13, GameSymbol.X),
            new Move(2, GameSymbol.X),
            new Move(15, GameSymbol.O),
            new Move(16, GameSymbol.O),
            new Move(17, GameSymbol.O),
            new Move(20, GameSymbol.X),
            new Move(21, GameSymbol.X),
            new Move(5, GameSymbol.O),
            new Move(40, GameSymbol.O)
    );

    private Configuration configuration1 = new Configuration(new BoardDimensions(3,3), 3);
    private Configuration configuration2 = new Configuration(new BoardDimensions(3,3), 2);
    private Configuration configuration3 = new Configuration(new BoardDimensions(5,7), 4);
    private Configuration configuration4 = new Configuration(new BoardDimensions(6,9), 3);

    @DataProvider
    public Object[][] getData() {
        return new Object[][] {
                {simpleCase1, configuration1},
                {simpleCase2, configuration1},
                {simpleCase3, configuration1},
                {simpleCase1, configuration2},
                {simpleCase2, configuration2},
                {simpleCase3, configuration2},
                {advancedCase1, configuration3},
                {advancedCase2, configuration3},
                {advancedCase3, configuration4}
        };
    }

    @DataProvider
    public Object[][] getAssertFailData(){
        return new Object[][] {
                {simpleWrongCase1, configuration1},
                {simpleWrongCase2, configuration1},
                {simpleWrongCase3, configuration1},
                {advancedWrongCase1, configuration3},
                {advancedWrongCase2, configuration3},
                {advancedWrongCase3, configuration4},

        };
    }
}
