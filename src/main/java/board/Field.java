package board;

import game.GameSymbol;

public class Field {

    private GameSymbol gameSymbol;
    private int position;

    public Field(){

    }

    public Field(int position){
        this.position = position;
    }

    public Field(int position, GameSymbol gameSymbol){
        this.gameSymbol = gameSymbol;
        this.position = position;
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
        String result = String.valueOf(position);
        if(!isEmpty()){
            result = gameSymbol.toString();
        }
        return result;
    }
}
