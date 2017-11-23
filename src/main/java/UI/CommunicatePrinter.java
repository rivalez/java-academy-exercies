package UI;

import java.util.ResourceBundle;

public class CommunicatePrinter {

    private ResourceBundle resourceBundle;
    private String game;
    private String start;

    public CommunicatePrinter(Language language){
        resourceBundle = ResourceBundle.getBundle(language.name().toLowerCase());
        game = resourceBundle.getString("game");
        start = resourceBundle.getString("start");
    }

    public String getGame() {
        return game;
    }
}
