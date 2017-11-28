package game;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.*;
import java.util.Arrays;
import java.util.List;


@Test
public class GameEngineTest extends GameEngineData {

    @Test(dataProvider = "drawTests")
    public void threeDrawInRow(String input, String expected) throws IOException {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        System.setOut(ps);
        GameEngine.main(new String[]{});
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        List testList = Arrays.asList(byteArrayOutputStream.toString().split("\n"));
        try(OutputStream outputStream = new FileOutputStream(expected + ".txt")) {
            byteArrayOutputStream.writeTo(outputStream);
        }

        Assert.assertTrue(testList.contains("REMIS! czesiek  -  O  -  score=3 jozek  -  X  -  score=3"));
    }

    @Test(dataProvider = "randomTests")
    public void sequenceOfTests(String input, String expected) throws IOException {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        System.setOut(ps);
        GameEngine.main(new String[]{});
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        try(OutputStream outputStream = new FileOutputStream(expected + ".txt")) {
            byteArrayOutputStream.writeTo(outputStream);
        }
    }
}