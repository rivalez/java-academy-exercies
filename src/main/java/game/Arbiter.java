package game;

import player.Player;

import java.util.List;

class Arbiter {

    void admitPoints(Player player){
        player.addScore(3);
    }

    void admitPoints(List<Player> players){
        players.forEach(player -> player.addScore(1));
    }

}
