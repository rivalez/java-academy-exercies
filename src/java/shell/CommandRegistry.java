package shell;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;

@Component
public class CommandRegistry {

    private HashMap<String, ShellCommand> commandMap = new HashMap<>();

    public ShellCommand getCommand(String commandName) {
        return commandMap.getOrDefault(commandName, Arrays::asList);
    }

    public void register(String commandName, ShellCommand command) {
        commandMap.put(commandName, command);
    }
}
