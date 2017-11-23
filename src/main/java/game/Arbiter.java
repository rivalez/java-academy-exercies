package game;

import player.Player;

import java.util.List;

class Arbiter {

    void admitPoints(Player player){
        player.getScore().addScore(3);
    }

    void admitPoints(List<Player> players){
        players.forEach(player -> player.getScore().addScore(1));
    }

}
