package game;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.*;
import java.util.Arrays;
import java.util.List;


@Test
public class GameEngineTest {

    public void threeDrawInRow() throws IOException {
        String gameString = "0\n1\n3\n3\n3\nx\njozek\nczesiek\n0\n1\n2\n3\n4\n5\n6\n7\n8\n0\n1\n2\n3\n4\n5\n6\n7\n8\n0\n1\n2\n3\n4\n5\n6\n7\n8\n";
        System.setIn(new ByteArrayInputStream(gameString.getBytes()));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        System.setOut(ps);
        GameEngine.main(new String[]{});
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        List testList = Arrays.asList(byteArrayOutputStream.toString().split("\n"));
        try(OutputStream outputStream = new FileOutputStream("draw.txt")) {
            byteArrayOutputStream.writeTo(outputStream);
        }

        Assert.assertTrue(testList.contains("REMIS! czesiek  -  O  -  score=3 jozek  -  X  -  score=3"));
    }
}