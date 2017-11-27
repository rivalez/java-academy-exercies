package board;

import game.GameSymbol;

public class Move implements Comparable<Move> {

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

    private boolean isEmpty(){
        return gameSymbol == null;
    }

    GameSymbol getGameSymbol() {
        return gameSymbol;
    }

    int getPosition() {
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

    @Override
    public int compareTo(Move move) {
        return Integer.compare(this.getPosition(), move.getPosition());
    }
}
