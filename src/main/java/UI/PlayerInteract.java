package UI;

import game.GameSymbol;

import java.util.Scanner;
import java.util.logging.Logger;

public class PlayerInteract {

    private Logger logger = Logger.getLogger(String.valueOf(PlayerInteract.class));
    private Scanner scanner = new Scanner(System.in);

    public int askForPosition(){
//        new CommunicatePrinter("please type number in which you want to place your symbol ").getMessage();
        int i = 0;
        try {
            i = scanner.nextInt();
        } catch (Exception e){
            logger.warning(e.getMessage());
//            new CommunicatePrinter("Something Went wrong try again...").getMessage();
            askForPosition();
        }
        return i;
    }

    public GameSymbol askForSymbol(){
//        new CommunicatePrinter("Who start's: O or X ?").getMessage();
        String symbol = scanner.next();
        GameSymbol gameSymbol = GameSymbol.X;
        try {
            gameSymbol = GameSymbol.valueOf(symbol);
        } catch (Exception e){
            askForSymbol();
        }
        return gameSymbol;
    }
}
