package board;

import game.GameSymbol;

public class Move {

    private GameSymbol gameSymbol;

    private int position;

    public Move(){

    }

    public Move(int position){
        this.position = position;
    }

    public Move(int position, GameSymbol gameSymbol){
        this.gameSymbol = gameSymbol;
        this.position = position;
    }

    public boolean isEmpty(){
        return gameSymbol == null;
    }

    public GameSymbol getGameSymbol() {
        return gameSymbol;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Move field = (Move) o;

        if (position != field.position) return false;
        return gameSymbol == field.gameSymbol;
    }

    @Override
    public int hashCode() {
        int result = gameSymbol != null ? gameSymbol.hashCode() : 0;
        result = 31 * result + position;
        return result;
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
