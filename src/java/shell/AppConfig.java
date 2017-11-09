package shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Configuration
@ComponentScan("shell")
public class AppConfig {

    @Autowired
    private CwdManager cwdManager;

    @Autowired
    private CommandRegistry commandRegistry;

    private Supplier<String> consoleReader = () -> new Scanner(System.in).nextLine();
    private Consumer<Exception> exceptionHandler = e -> System.out.println("Exception occured:" + e.getMessage());


    @Bean
    public PromptManager promptManager() {
        return new PromptManager(cwdManager);
    }

    @Bean
    public MyShell myShell() {
        return new MyShell(consoleReader, commandRegistry, System.out::println, exceptionHandler, promptManager());
    }
}