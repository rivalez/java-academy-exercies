package game;

import player.Player;

import java.util.List;

public class Turn {

    private List<Player> players;
    private Player currentPlayer;

    public Turn(List<Player> players) {
        this.players = players;
    }

    public Player getNext() {
        return currentPlayer;
    }
}
