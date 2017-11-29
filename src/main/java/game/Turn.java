package game;

import player.Player;

import java.util.Collections;
import java.util.List;

class Turn {

    private List<Player> players;

    Turn(List<Player> players) {
        this.players = players;
    }

    Player getLast(){
        return players.get(1);
    }

    Player getNext() {
        Collections.reverse(players);
        return players.get(1);
    }

    List<Player> getPlayers() {
        return players;
    }
}
