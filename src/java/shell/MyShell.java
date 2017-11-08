package shell;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class MyShell {

    private final Supplier<String> consoleReader;
    private final CommandRegistry commandRegistry;
    private final Consumer<String> consoleWriter;
    private final Consumer<Exception> exceptionHandler;
    private PromptManager promptManager;

    @Autowired
    public MyShell(Supplier<String> consoleReader, CommandRegistry commandRegistry, Consumer<String> consoleWriter, Consumer<Exception> exceptionHandler, PromptManager promptManager) {
        this.consoleReader = consoleReader;
        this.commandRegistry = commandRegistry;
        this.consoleWriter = consoleWriter;
        this.exceptionHandler = exceptionHandler;
        this.promptManager = promptManager;
    }

    public void loop() {
        while(true){
            try{
                readInputExecuteAndDisplayResult();
            } catch (Exception e){
                exceptionHandler.accept(e);
            }
        }
    }

    void readInputExecuteAndDisplayResult() {
        consoleWriter.accept(promptManager.getPrompt());
        String userInput = consoleReader.get();
        String[] commandLine = userInput.split(" ");
        String commandName = commandLine[0];
        ShellCommand c = commandRegistry.getCommand(commandName);
        List<String> output = c.execute(commandLine);
        output.forEach(consoleWriter);
    }
}
