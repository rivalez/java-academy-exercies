package UI;

import game.GameSymbol;
import player.Player;

import java.util.Scanner;
import java.util.logging.Logger;

public class PlayerInteract {

    private Logger logger = Logger.getLogger(String.valueOf(PlayerInteract.class));
    private Scanner scanner = new Scanner(System.in, "UTF-8");
    private CommunicateProvider communicateProvider;
    private Output output;

    public PlayerInteract(CommunicateProvider communicateProvider, Output output){
        this.output = output;
        this.communicateProvider = communicateProvider;
    }

    public int askForPosition(){
        output.display(communicateProvider.getCommunicate(Communicate.SYMBOL));
        int i = 0;
        try {
            i = scanner.nextInt();
        } catch (Exception e){
            logger.warning(e.getMessage());
            output.display(communicateProvider.getCommunicate(Communicate.WRONG_GLOBAL));
            askForPosition();
        }
        return i;
    }

    public GameSymbol askForSymbol(){
        output.display(communicateProvider.getCommunicate(Communicate.WHO_START));
        String symbol = scanner.next();
        GameSymbol gameSymbol = GameSymbol.X;
        try {
            gameSymbol = GameSymbol.valueOf(symbol.toUpperCase());
        } catch (Exception e){
            askForSymbol();
        }
        return gameSymbol;
    }
}
