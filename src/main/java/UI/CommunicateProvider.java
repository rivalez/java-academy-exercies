package UI;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import static UI.Communicate.*;

public class CommunicateProvider {

    private ResourceBundle resourceBundle;
    private Map<Communicate, String> communicates = new HashMap<>();

    public CommunicateProvider populate(Language language){
        this.resourceBundle = ResourceBundle.getBundle(language.name());
        communicates.put(GAME, resourceBundle.getString(GAME.name()));
        communicates.put(START, resourceBundle.getString(START.name()));
        communicates.put(RULES, resourceBundle.getString(RULES.name()));
        communicates.put(HORIZONTAL, resourceBundle.getString(HORIZONTAL.name()));
        communicates.put(VERTICAL, resourceBundle.getString(VERTICAL.name()));
        communicates.put(CORRECT_INPUT, resourceBundle.getString(CORRECT_INPUT.name()));
        communicates.put(SYMBOL_TO_WIN, resourceBundle.getString(SYMBOL_TO_WIN.name()));
        communicates.put(INCORRECT_CONFIG, resourceBundle.getString(INCORRECT_CONFIG.name()));
        communicates.put(CURRENT_PLAYER_TURN, resourceBundle.getString(CURRENT_PLAYER_TURN.name()));
        communicates.put(WRONG_TURN, resourceBundle.getString(WRONG_TURN.name()));
        communicates.put(FINISH, resourceBundle.getString(FINISH.name()));
        communicates.put(EXIT, resourceBundle.getString(EXIT.name()));
        communicates.put(CREATED, resourceBundle.getString(CREATED.name()));
        communicates.put(FIRST_PLAYER, resourceBundle.getString(FIRST_PLAYER.name()));
        communicates.put(SECOND_PLAYER, resourceBundle.getString(SECOND_PLAYER.name()));
        communicates.put(START_FIRST, resourceBundle.getString(START_FIRST.name()));
        communicates.put(SYMBOL, resourceBundle.getString(SYMBOL.name()));
        communicates.put(WRONG_GLOBAL, resourceBundle.getString(WRONG_GLOBAL.name()));
        communicates.put(WHO_START, resourceBundle.getString(WHO_START.name()));
        return this;
    }

    public String getCommunicate(Communicate communicate) {
        return communicates.get(communicate);
    }
}