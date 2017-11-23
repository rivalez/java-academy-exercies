package UI;

import game.GameSymbol;

import java.util.Scanner;

public class PlayerInteract {

    private Scanner scanner = new Scanner(System.in);

    public int askForPosition(){
        new Communicate("please type number in which you want to place your symbol ").getMessage();
        int i = 0;
        try {
            i = scanner.nextInt();
        } catch (Exception e){
            new Communicate("Something Went wrong try again...").getMessage();
            askForPosition();
        }
        return i;
    }

    public GameSymbol askForSymbol(){
        new Communicate("Who start's: O or X ?").getMessage();
        String symbol = scanner.next();
        GameSymbol gameSymbol = null;
        try {
            gameSymbol = GameSymbol.valueOf(symbol);
        } catch (Exception e){
            askForSymbol();
        }
        return gameSymbol;
    }
}
