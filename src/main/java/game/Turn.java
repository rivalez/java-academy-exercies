package game;

import player.Player;

import java.util.Collections;
import java.util.List;

public class Turn {

    private List<Player> players;

    public Turn(List<Player> players) {
        this.players = players;
    }

    public Player getNext() {
        Collections.reverse(players);
        return players.get(1);
    }
}
