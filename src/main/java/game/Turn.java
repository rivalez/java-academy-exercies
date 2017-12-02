package game;

import player.Player;

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
