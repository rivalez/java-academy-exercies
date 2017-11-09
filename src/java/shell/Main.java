package shell;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Supplier<String> consoleReader = () -> new Scanner(System.in).nextLine();
        Consumer<Exception> exceptionHandler = e -> System.out.println("Exception occured:" + e.getMessage());
        CommandRegistry commandRegistry = (CommandRegistry)context.getBean("commandRegistry");

        PromptManager promptManager = (PromptManager) context.getBean("promptManager");
        MyShell myShell = new MyShell(consoleReader, commandRegistry, System.out::println, exceptionHandler, promptManager);

        myShell.loop();
    }
}
