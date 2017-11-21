package board;

import game.GameSymbol;
import org.testng.annotations.DataProvider;

import java.util.Arrays;
import java.util.List;

/**
 * Created by marek on 19.11.2017.
 */
public class RowData extends BaseTest {

    private List<Move> simpleCase1 = Arrays.asList(
            new Move(0, GameSymbol.X),
            new Move(1, GameSymbol.X),
            new Move(2, GameSymbol.X));

    private List<Move> simpleCase2 = Arrays.asList(
            new Move(1, GameSymbol.X),
            new Move(2, GameSymbol.X),
            new Move(4, GameSymbol.O),
            new Move(7, GameSymbol.O),
            new Move(0, GameSymbol.X));

    private List<Move> simpleCase3 = Arrays.asList(
            new Move(0, GameSymbol.O),
            new Move(7, GameSymbol.X),
            new Move(1, GameSymbol.O),
            new Move(2, GameSymbol.O),
            new Move(3, GameSymbol.O),
            new Move(8, GameSymbol.X),
            new Move(5, GameSymbol.O),
            new Move(6, GameSymbol.X)
    );

    private List<Move> advancedCase1 = Arrays.asList(
            new Move(8, GameSymbol.O),
            new Move(30, GameSymbol.X),
            new Move(31, GameSymbol.X),
            new Move(1, GameSymbol.X),
            new Move(7, GameSymbol.O),
            new Move(13, GameSymbol.X),
            new Move(2, GameSymbol.X),
            new Move(6, GameSymbol.O),
            new Move(20, GameSymbol.X),
            new Move(21, GameSymbol.X),
            new Move(5, GameSymbol.O)
    );

    private List<Move> simpleWrongCase1 = Arrays.asList(
            new Move(8, GameSymbol.O),
            new Move(30, GameSymbol.X),
            new Move(31, GameSymbol.X),
            new Move(1, GameSymbol.X),
            new Move(7, GameSymbol.X),
            new Move(13, GameSymbol.X),
            new Move(2, GameSymbol.X),
            new Move(6, GameSymbol.O),
            new Move(20, GameSymbol.X),
            new Move(21, GameSymbol.X),
            new Move(5, GameSymbol.X)
    );

    private List<Move> simpleWrongCase2 = Arrays.asList(
            new Move(2, GameSymbol.X),
            new Move(6, GameSymbol.O),
            new Move(1, GameSymbol.O),
            new Move(0, GameSymbol.O),
            new Move(3, GameSymbol.O),
            new Move(5, GameSymbol.X),
            new Move(7, GameSymbol.O),
            new Move(8, GameSymbol.X)
    );

    private List<Move> simpleWrongCase3 = Arrays.asList(
            new Move(2, GameSymbol.X),
            new Move(6, GameSymbol.O),
            new Move(1, GameSymbol.O),
            new Move(0, GameSymbol.X),
            new Move(3, GameSymbol.O),
            new Move(5, GameSymbol.X),
            new Move(7, GameSymbol.O),
            new Move(8, GameSymbol.X)
    );

    private List<Move> advancedWrongCase1 = Arrays.asList(
            new Move(2, GameSymbol.X),
            new Move(6, GameSymbol.O),
            new Move(1, GameSymbol.O),
            new Move(0, GameSymbol.X),
            new Move(3, GameSymbol.O),
            new Move(5, GameSymbol.X),
            new Move(7, GameSymbol.O),
            new Move(8, GameSymbol.X),
            new Move(20, GameSymbol.X),
            new Move(21, GameSymbol.X),
            new Move(22, GameSymbol.X),
            new Move(23, GameSymbol.O),
            new Move(24, GameSymbol.O)
    );

    private List<Move> advancedWrongCase2 = Arrays.asList(
            new Move(15, GameSymbol.X),
            new Move(11, GameSymbol.O),
            new Move(7, GameSymbol.X),
            new Move(3, GameSymbol.O),
            new Move(4, GameSymbol.X),
            new Move(2, GameSymbol.O),
            new Move(5, GameSymbol.X)
    );


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
        };
    }

    @DataProvider
    public Object[][] getInvalidData() {
        return new Object[][] {
                {simpleWrongCase1, configuration3},
                {simpleWrongCase2, configuration1},
                {simpleWrongCase3, configuration2},
                {advancedWrongCase1, configuration3},
                {advancedWrongCase2, configuration6},
        };
    }
}
