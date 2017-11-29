package game;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class GameEngineTest extends GameEngineData {

    private FileWriter fw;

    @BeforeTest
    public void setUp() throws IOException {
        fw = new FileWriter("all.txt", true);
    }

    @AfterTest
    public void tearDown() throws IOException {
        fw.close();
    }

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
        fw.write(Collections.singletonList(byteArrayOutputStream.toString()).toString());
        try(OutputStream outputStream = new FileOutputStream(expected + ".txt")) {
            byteArrayOutputStream.writeTo(outputStream);
        }
    }

    @Test(dataProvider = "randomInputs")
    public void randomInput(String input) throws IOException {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        System.setOut(ps);
        GameEngine.main(new String[]{});
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        fw.write(Collections.singletonList(byteArrayOutputStream.toString()).toString());
    }
}