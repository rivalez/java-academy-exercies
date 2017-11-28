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
        StringBuilder sb = new StringBuilder();
        if(players.get(0).getScore().getValue() > players.get(1).getScore().getValue()){
            return sb.append(players.get(0))
                    .append(" ")
                    .append(communicateProvider.getCommunicate(Communicate.WON)).toString();
        } else if (players.get(0).getScore().getValue() < players.get(1).getScore().getValue()) {
            return sb.append(players.get(1))
                    .append(" ")
                    .append(communicateProvider.getCommunicate(Communicate.WON)).toString();
        } else {
            return sb.append(communicateProvider.getCommunicate(Communicate.DRAW))
                    .append(players.get(0))
                    .append(" ")
                    .append(players.get(1)).toString();
        }
    }
}