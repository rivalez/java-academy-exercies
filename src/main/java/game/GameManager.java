package game;

import UI.Communicate;
import UI.CommunicateProvider;
import player.Player;

import java.util.List;

class GameManager {

    private Turn turn;
    private CommunicateProvider communicateProvider;

    GameManager(Turn turn, CommunicateProvider communicateProvider){
        this.turn = turn;
        this.communicateProvider = communicateProvider;
    }

    String result() {
        List<Player> players = turn.getPlayers();
        if(players.get(0).getScore().getValue() > players.get(1).getScore().getValue()){
            return players.get(0) + communicateProvider.getCommunicate(Communicate.WON);
        } else if (players.get(0).getScore().getValue() < players.get(1).getScore().getValue()) {
            return players.get(1) + communicateProvider.getCommunicate(Communicate.WON);
        } else {
            return communicateProvider.getCommunicate(Communicate.DRAW) + players.get(0) + " " + players.get(1);
        }
    }
}