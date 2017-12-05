package game;

import player.Player;
import ui.Communicate;
import ui.CommunicateProvider;

import java.util.List;

class GameManager {

    private TurnManager turn;
    private CommunicateProvider communicateProvider;

    GameManager(TurnManager turn, CommunicateProvider communicateProvider){
        this.turn = turn;
        this.communicateProvider = communicateProvider;
    }

    String result() {
        List<Player> players = turn.getPlayers();
        StringBuilder sb = new StringBuilder();
        //strategy, alert, get 0,1 bad smell
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