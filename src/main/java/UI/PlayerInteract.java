package UI;

import game.GameSymbol;
import player.Player;

import java.util.Scanner;
import java.util.logging.Logger;

public class PlayerInteract {

    private Logger logger = Logger.getLogger(String.valueOf(PlayerInteract.class));
    private CommunicateProvider communicateProvider;
    private Output output;
    private MyScanner scanner;

    public PlayerInteract(CommunicateProvider communicateProvider, Output output, MyScanner scanner){
        this.output = output;
        this.communicateProvider = communicateProvider;
        this.scanner = scanner;
    }

    public int askForPosition() {
        int i = 0;
        try {
            output.display(communicateProvider.getCommunicate(Communicate.SYMBOL));
            i = Integer.valueOf(scanner.nextLine());
        } catch (Exception e){
            logger.warning(e.getMessage());
            output.display(communicateProvider.getCommunicate(Communicate.WRONG_GLOBAL));
        }
        return i;
    }

    public GameSymbol askForSymbol() {
        GameSymbol gameSymbol = GameSymbol.X;
        try {
            output.display(communicateProvider.getCommunicate(Communicate.WHO_START));
            String symbol = scanner.nextLine();
            gameSymbol = GameSymbol.valueOf(symbol.toUpperCase());
        } catch (Exception e) {
            logger.warning(communicateProvider.getCommunicate(Communicate.WRONG_GLOBAL));
        }
        return gameSymbol;
    }
}
