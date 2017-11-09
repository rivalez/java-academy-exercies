package game;

import player.Player;

public class Turn {

    private Player player;

    public Turn(Player player) {
        this.player = player;
    }


    public Player getPlayer() {
        return player;
    }
}
