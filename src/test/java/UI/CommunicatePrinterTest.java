package UI;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class CommunicatePrinterTest {
    public void polishLoad(){
        //given
        CommunicatePrinter communicatePrinter = new CommunicatePrinter(Language.ENGLISH);

        //when-then
        Assert.assertEquals(communicatePrinter.getGame(),"OX-GAME-1.0 BETA. ENJOY.");
    }
}