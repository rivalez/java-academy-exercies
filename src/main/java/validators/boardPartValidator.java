package validators;

import board.Field;
import game.Configuration;

import java.util.List;

public class boardPartValidator {

    private Configuration configuration;

    public boardPartValidator(Configuration configuration){
        this.configuration = configuration;
    }

    public boolean validate(List<Field> fields) {
        int symbolsToWin = configuration.getGameSymbolsToWin() - 1;
        int counter = 0;
        for (int i = 0; i < fields.size(); i++) {
            if(i + 1 < fields.size() && fields.get(i).equals(fields.get(i + 1))){
                counter++;
                if (counter == symbolsToWin) return true;
            } else {
                counter = 0;
            }
        }
        return false;
    }
}
