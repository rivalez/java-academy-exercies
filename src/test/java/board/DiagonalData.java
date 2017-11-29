package board;

import game.GameSymbol;
import org.testng.annotations.DataProvider;

import java.util.Arrays;
import java.util.List;

/**
 * Created by marek on 19.11.2017.
 */
public class DiagonalData extends BaseTest {

    private List<Move> simpleCase1 = Arrays.asList(
            new Move(0, GameSymbol.X),
            new Move(4, GameSymbol.X),
            new Move(8, GameSymbol.X));

    private List<Move> simpleCase2 = Arrays.asList(
            new Move(0, GameSymbol.X),
            new Move(4, GameSymbol.X),
            new Move(4, GameSymbol.O),
            new Move(7, GameSymbol.O),
            new Move(8, GameSymbol.X));

    private List<Move> simpleCase3 = Arrays.asList(
            new Move(0, GameSymbol.O),
            new Move(8, GameSymbol.X),
            new Move(1, GameSymbol.O),
            new Move(2, GameSymbol.O),
            new Move(3, GameSymbol.O),
            new Move(4, GameSymbol.X),
            new Move(5, GameSymbol.O),
            new Move(0, GameSymbol.X)
    );

    private List<Move> advancedCase1 = Arrays.asList(
            new Move(0, GameSymbol.O),
            new Move(30, GameSymbol.X),
            new Move(31, GameSymbol.X),
            new Move(1, GameSymbol.X),
            new Move(6, GameSymbol.O),
            new Move(13, GameSymbol.X),
            new Move(2, GameSymbol.X),
            new Move(12, GameSymbol.O),
            new Move(20, GameSymbol.X),
            new Move(21, GameSymbol.X),
            new Move(18, GameSymbol.O)
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

    private List<Move> advancedWrongCase4 = Arrays.asList(
            new Move(39, GameSymbol.X),
            new Move(33, GameSymbol.O),
            new Move(34, GameSymbol.X),
            new Move(30, GameSymbol.O),
            new Move(31, GameSymbol.X),
            new Move(24, GameSymbol.O),
            new Move(25, GameSymbol.X),
            new Move(16, GameSymbol.O),
            new Move(0, GameSymbol.X),
            new Move(23, GameSymbol.O),
            new Move(32, GameSymbol.X),
            new Move(35, GameSymbol.O),
            new Move(26, GameSymbol.X),
            new Move(27, GameSymbol.O),
            new Move(19, GameSymbol.X)
    );


    private List<Move> advancedWrongCase5 = Arrays.asList(
            new Move(11, GameSymbol.X),
            new Move(17, GameSymbol.X),
            new Move(23, GameSymbol.X),
            new Move(16, GameSymbol.X),
            new Move(41, GameSymbol.X),
            new Move(10, GameSymbol.X),
            new Move(15, GameSymbol.X),
            new Move(14, GameSymbol.X)
    );

    @DataProvider
    public Object[][] getAssertFailData(){
        return new Object[][] {
                {simpleWrongCase1, configuration1},
                {simpleWrongCase2, configuration1},
                {simpleWrongCase3, configuration1},
                {advancedWrongCase1, configuration3},
                {advancedWrongCase2, configuration3},
                {advancedWrongCase3, configuration4},
                {advancedWrongCase4, configuration5},
                {advancedWrongCase5, configuration5},
        };
    }

    private List<Move> simpleLeftToRightCase1 = Arrays.asList(
            new Move(2, GameSymbol.X),
            new Move(4, GameSymbol.X),
            new Move(6, GameSymbol.X));


    private List<Move> simpleLeftToRightCase2 = Arrays.asList(
            new Move(6, GameSymbol.X),
            new Move(3, GameSymbol.X),
            new Move(9, GameSymbol.X));


    private List<Move> simpleLeftToRightCase3 = Arrays.asList(
            new Move(7, GameSymbol.X),
            new Move(10, GameSymbol.X),
            new Move(13, GameSymbol.X));

    private List<Move> simpleLeftToRightCase4 = Arrays.asList(
            new Move(12, GameSymbol.X),
            new Move(9, GameSymbol.X),
            new Move(6, GameSymbol.X));


    private List<Move> advancedLeftToRightCase1 = Arrays.asList(
            new Move(9, GameSymbol.X),
            new Move(18, GameSymbol.X),
            new Move(36, GameSymbol.X),
            new Move(27, GameSymbol.X));

    private List<Move> advancedLeftToRightCase2 = Arrays.asList(
            new Move(3, GameSymbol.X),
            new Move(12, GameSymbol.X),
            new Move(21, GameSymbol.X),
            new Move(30, GameSymbol.X));


    private List<Move> simpleLeftToWrongCase1 = Arrays.asList(
            new Move(0, GameSymbol.X),
            new Move(1, GameSymbol.O),
            new Move(2, GameSymbol.X),
            new Move(3, GameSymbol.O),
            new Move(4, GameSymbol.X));

    private List<Move> rightUpToDownLeftCase1 = Arrays.asList(
            new Move(0, GameSymbol.O),
            new Move(5, GameSymbol.X),
            new Move(2, GameSymbol.O),
            new Move(1, GameSymbol.X),
            new Move(4, GameSymbol.O),
            new Move(3, GameSymbol.X),
            new Move(6, GameSymbol.O));


    @DataProvider
    public Object[][] getCorrect(){
        return new Object[][] {
                {simpleLeftToRightCase1, configuration1},
                {simpleLeftToRightCase2, configuration6},
                {simpleLeftToRightCase3, configuration6},
                {simpleLeftToRightCase4, configuration6},
                {advancedLeftToRightCase1, configuration10},
                {advancedLeftToRightCase2, configuration10},
                {rightUpToDownLeftCase1, configuration1},
        };
    }

    @DataProvider
    public Object[][] getInvalid() {
        return new Object[][] {
                {simpleLeftToWrongCase1, configuration1},
        };
    }
}