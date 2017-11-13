package validators;

import board.Field;

import java.util.List;

public class RowValidator {
    public boolean validate(List<Field> fields) {
        int i = fields.size() / 2;
        return fields.get(i - 1).equals(fields.get(i)) && fields.get(i).equals(fields.get(i + 1)) ;
    }
}
