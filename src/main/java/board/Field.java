package board;

import game.GameSymbol;

public class Field {

    private GameSymbol gameSymbol;

    public Field(){

    }

    public Field(GameSymbol gameSymbol){
        this.gameSymbol = gameSymbol;
    }

    public boolean isEmpty(){
        return gameSymbol == null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Field field = (Field) o;

        return gameSymbol == field.gameSymbol;
    }

    @Override
    public int hashCode() {
        return gameSymbol != null ? gameSymbol.hashCode() : 0;
    }

    @Override
    public String toString() {
        String result = ".";
        if(!isEmpty()){
            result = gameSymbol.toString();
        }
        return result;
    }
}
