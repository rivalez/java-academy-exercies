package ui;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;

@Test
public class OutputProviderTest {

    public void standardOutput(){
        //given
        InputStream in = new ByteArrayInputStream("0\n".getBytes(Charset.forName("UTF-8")));
        System.setIn(in);
        OutputProvider outputProvider = new OutputProvider(new MyScannerImpl());

        //when
        Output output = outputProvider.askForOutputType();

        //then
        Assert.assertTrue(output instanceof SystemPrintOut);
    }

    public void errOutput(){
        //given
        InputStream in = new ByteArrayInputStream("1\n".getBytes(Charset.forName("UTF-8")));
        System.setIn(in);
        OutputProvider outputProvider = new OutputProvider(new MyScannerImpl());

        //when
        Output output = outputProvider.askForOutputType();

        //then
        Assert.assertTrue(output instanceof SystemErrOut);
    }

    public void standardOutputInvalid(){
        //given
        InputStream in = new ByteArrayInputStream("gfdsgdf';;;;;\n".getBytes(Charset.forName("UTF-8")));
        System.setIn(in);
        OutputProvider outputProvider = new OutputProvider(new MyScannerImpl());

        //when
        Output output = outputProvider.askForOutputType();

        //then
        Assert.assertTrue(output instanceof SystemPrintOut);
    }
}
