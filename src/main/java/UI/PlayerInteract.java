package UI;

import game.GameSymbol;
import player.Player;

import java.util.Scanner;
import java.util.logging.Logger;

public class PlayerInteract {

    private Logger logger = Logger.getLogger(String.valueOf(PlayerInteract.class));
    private CommunicateProvider communicateProvider;
    private Output output;

    public PlayerInteract(CommunicateProvider communicateProvider, Output output){
        this.output = output;
        this.communicateProvider = communicateProvider;
    }

    public int askForPosition() {
        int i = 0;
        try {
            Scanner scanner = new Scanner(System.in, "UTF-8");
            output.display(communicateProvider.getCommunicate(Communicate.SYMBOL));
            i = scanner.nextInt();
        } catch (Exception e){
            logger.warning(e.getMessage());
            output.display(communicateProvider.getCommunicate(Communicate.WRONG_GLOBAL));
            askForPosition();
        }
        return i;
    }

    public GameSymbol askForSymbol() {
        GameSymbol gameSymbol = GameSymbol.X;
        try {
            Scanner scanner = new Scanner(System.in, "UTF-8");
            output.display(communicateProvider.getCommunicate(Communicate.WHO_START));
            String symbol = scanner.next();
            gameSymbol = GameSymbol.valueOf(symbol.toUpperCase());
        } catch (Exception e){
            logger.warning(communicateProvider.getCommunicate(Communicate.WRONG_GLOBAL));
            askForSymbol();
        }
        return gameSymbol;
    }
}
