package game;

import player.Player;

import java.util.List;

class Arbiter {

    private static final int WIN = 3;
    private static final int DRAW = 1;

    void admitPoints(Player player){
        player.addScore(WIN);
    }

    void admitPoints(List<Player> players){
        players.forEach(player -> player.addScore(DRAW));
    }

}
