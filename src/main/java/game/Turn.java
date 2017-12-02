package game;

import player.Player;
import ui.Communicate;
import ui.CommunicateProvider;
import ui.Output;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Turn {

    private List<Player> players;

    Turn(List<Player> players) {
        this.players = players;
    }
    Player getFirst(){
        return players.get(0);
    }

    Player getNext() {
        Collections.reverse(players);
        return players.get(0);
    }

    List<Player> getPlayers() {
        return players;
    }
}
