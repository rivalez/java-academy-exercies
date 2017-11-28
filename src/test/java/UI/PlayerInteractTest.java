package UI;

import game.GameSymbol;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;

@Test
public class PlayerInteractTest {

    public void askForPosition() {
        //given
        InputStream in = new ByteArrayInputStream("0\n".getBytes(Charset.forName("UTF-8")));
        System.setIn(in);
        MyScanner myScanner = new MyScannerImpl();
        CommunicateProvider communicateProvider = new CommunicateProvider();
        PlayerInteract playerInteract = new PlayerInteract(communicateProvider, new SystemErrOut(), myScanner);
        //when-then
        Assert.assertEquals(playerInteract.askForPosition(), 0);
    }
    public void askForSymbolO() {
        //given
        InputStream in = new ByteArrayInputStream("o".getBytes(Charset.forName("UTF-8")));
        System.setIn(in);
        MyScanner myScanner = new MyScannerImpl();
        CommunicateProvider communicateProvider = new CommunicateProvider();
        PlayerInteract playerInteract = new PlayerInteract(communicateProvider, new SystemErrOut(), myScanner);
        //when-then
        Assert.assertEquals(playerInteract.askForSymbol(), GameSymbol.O);
    }

    public void askForSymbolX() {
        //given
        InputStream in = new ByteArrayInputStream("x".getBytes(Charset.forName("UTF-8")));
        System.setIn(in);
        MyScanner myScanner = new MyScannerImpl();
        CommunicateProvider communicateProvider = new CommunicateProvider();
        PlayerInteract playerInteract = new PlayerInteract(communicateProvider, new SystemErrOut(), myScanner);
        //when-then
        Assert.assertEquals(playerInteract.askForSymbol(), GameSymbol.X);
    }
}