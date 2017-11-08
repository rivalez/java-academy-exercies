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
        CwdManager cwdManager = (CwdManager)context.getBean("cwdManager");
        CommandRegistry commandRegistry = (CommandRegistry)context.getBean("commandRegistry");
        PromptManager promptManager = new PromptManager(cwdManager);
        MyShell myShell = new MyShell(consoleReader, commandRegistry, System.out::println, exceptionHandler, promptManager);

        commandRegistry.register("dir", new DirCommand(cwdManager));
        commandRegistry.register("cd", new CdCommand(cwdManager));
        commandRegistry.register("prompt", new PromptCommand(promptManager));
        myShell.loop();
    }
}
