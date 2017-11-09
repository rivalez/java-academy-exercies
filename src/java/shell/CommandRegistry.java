package shell;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;

@Component
public class CommandRegistry implements BeanPostProcessor{

    @Autowired
    private CdCommand cdCommand;

    @Autowired
    private DirCommand dirCommand;

    @Autowired
    private PromptCommand promptCommand;

    private HashMap<String, ShellCommand> commandMap = new HashMap<>();

    public ShellCommand getCommand(String commandName) {
        return commandMap.getOrDefault(commandName, Arrays::asList);
    }

    public void register(String commandName, ShellCommand command) {
        commandMap.put(commandName, command);
    }

    @Nullable
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        register("cd", cdCommand);
        register("dir", dirCommand);
        register("prompt", promptCommand);
        return null;
    }

    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }
}
