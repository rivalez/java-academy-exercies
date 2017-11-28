package UI;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;

@Test
public class LanguageProviderTest {

    public void languagePolish(){
        //given
        InputStream in = new ByteArrayInputStream("1\n".getBytes(Charset.forName("UTF-8")));
        System.setIn(in);

        LanguageProvider languageProvider = new LanguageProvider(new SystemPrintOut(), new MyScannerImpl());

        //when
        Language language = languageProvider.askForLanguage();

        //then
        Assert.assertEquals(language, Language.POLISH);
    }

    public void languageEnglish(){
        //given
        InputStream in = new ByteArrayInputStream("0\n".getBytes(Charset.forName("UTF-8")));
        System.setIn(in);

        LanguageProvider languageProvider = new LanguageProvider(new SystemPrintOut(), new MyScannerImpl());

        //when
        Language language = languageProvider.askForLanguage();

        //then
        Assert.assertEquals(language, Language.ENGLISH);
    }


    public void languageInvalid(){
        //given
        InputStream in = new ByteArrayInputStream("ssd---k///0\n".getBytes(Charset.forName("UTF-8")));
        System.setIn(in);

        LanguageProvider languageProvider = new LanguageProvider(new SystemPrintOut(), new MyScannerImpl());

        //when
        Language language = languageProvider.askForLanguage();

        //then
        Assert.assertEquals(language, Language.ENGLISH);
    }
}
