package game;

import java.util.ArrayList;
import java.util.List;

public class Sequence {

    private Configuration configuration;

    public Sequence(Configuration configuration){
        this.configuration = configuration;
    }

    public WinSequence createRowSequence(int position) {
        List<Integer> result = new ArrayList<>();
        int size = configuration.getBoardDimensions().getY() * configuration.getBoardDimensions().getX();

        for (int i = 0; i < configuration.getGameSymbolsToWin(); i++) {
            if(position >= 0 && position <= size){
                //0,1,2
                //3,4,5
                //6,7,8
                //0,4,8
                //0,3,6
                //1,4,7
                //2,5,8
                //2,4,6
            }
        }
        return new WinSequence(result);
    }

}
