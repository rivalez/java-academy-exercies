package shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("shell")
public class AppConfig {

    @Autowired
    private CwdManager cwdManager;

    @Bean
    public PromptManager promptManager(){
        return new PromptManager(cwdManager);
    }

//    @Bean
//    public MyShell myShell(){
//        return new MyShell();
//    }
}