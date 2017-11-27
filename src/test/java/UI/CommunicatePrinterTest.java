package UI;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class CommunicatePrinterTest {
    public void polishLoad(){
        //given
        CommunicateProvider communicateProvider = new CommunicateProvider().populate(Language.POLISH);

        //when-then
        Assert.assertEquals(communicateProvider.getCommunicate(Communicate.GAME),"OX-GAME-1.0 BETA. Powodzenia.");
        Assert.assertEquals(communicateProvider.getCommunicate(Communicate.CORRECT_INPUT),"Proszę przekaż poprawne wejście");
        Assert.assertEquals(communicateProvider.getCommunicate(Communicate.START),"Gra wystartowała.");
        Assert.assertEquals(communicateProvider.getCommunicate(Communicate.SYMBOL_TO_WIN),"Proszę podaj ilość znaków koniecznych do skończenia gry");
        Assert.assertEquals(communicateProvider.getCommunicate(Communicate.CREATED),"Plansza została utworzona!");
        Assert.assertEquals(communicateProvider.getCommunicate(Communicate.CURRENT_PLAYER_TURN),"Bierząca tura gracza");
        Assert.assertEquals(communicateProvider.getCommunicate(Communicate.EXIT),"żeby wyjść wcisnij '-'");
        Assert.assertEquals(communicateProvider.getCommunicate(Communicate.HORIZONTAL),"Podaj szerokość planszy:");
        Assert.assertEquals(communicateProvider.getCommunicate(Communicate.WHO_START),"Kto zaczyna: O czy X ?");
        Assert.assertEquals(communicateProvider.getCommunicate(Communicate.WRONG_GLOBAL),"Coś poszło nie tak, spróbuj ponownie...");
    }

    public void englishLoad(){
        //given
        CommunicateProvider communicateProvider = new CommunicateProvider().populate(Language.ENGLISH);

        //when-then
        Assert.assertEquals(communicateProvider.getCommunicate(Communicate.GAME),"OX-GAME-1.0 BETA. ENJOY.");
        Assert.assertEquals(communicateProvider.getCommunicate(Communicate.RULES),"To create game system will ask you for configuration data. In case if your data isn't correct system will provide standard 3x3 board.");
        Assert.assertEquals(communicateProvider.getCommunicate(Communicate.START_FIRST),"Player %s starts first");
        Assert.assertEquals(communicateProvider.getCommunicate(Communicate.INCORRECT_CONFIG),"Your configuration was not correct, providing correct one...");
        Assert.assertEquals(communicateProvider.getCommunicate(Communicate.WRONG_TURN),"Wrong move dude, you lost turn!");
        Assert.assertEquals(communicateProvider.getCommunicate(Communicate.SECOND_PLAYER),"Provide name of second player: ");
        Assert.assertEquals(communicateProvider.getCommunicate(Communicate.SYMBOL_TO_WIN),"Type number of game symbols necessary to win game");
    }
}