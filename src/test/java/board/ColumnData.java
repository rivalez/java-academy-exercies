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

    private Configuration configuration1 = new Configuration(new BoardDimensions(3,3), 3);
    private Configuration configuration2 = new Configuration(new BoardDimensions(3,3), 2);
    private Configuration configuration3 = new Configuration(new BoardDimensions(5,7), 4);

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
}
