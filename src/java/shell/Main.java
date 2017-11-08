package shell;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {

    @Autowired
    static MyShell myShell;

    @Autowired
    static CwdManager cwdManager;

    public static void main(String[] args) {
        Supplier<String> consoleReader = () -> new Scanner(System.in).nextLine();
        Consumer<Exception> exceptionHandler = e -> System.out.println("Exception occured:" + e.getMessage());
        PromptManager promptManager = new PromptManager(cwdManager);

        CommandRegistry commandRegistry = new CommandRegistry();
//        commandRegistry.register("dir", new DirCommand(cwdManager));
//        commandRegistry.register("cd", new CdCommand(cwdManager));
//        commandRegistry.register("prompt", new PromptCommand(promptManager));
        myShell.loop();
    }
}
