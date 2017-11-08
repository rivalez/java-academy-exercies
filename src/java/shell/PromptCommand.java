package shell;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

public class PromptCommand implements ShellCommand {

    @Autowired
    private final PromptManager promptManager;

    public PromptCommand(PromptManager cwdManager) {
        this.promptManager = cwdManager;
    }

    @Override
    public List<String> execute(String[] commandLine) {
        promptManager.setPromptCwd();

        return Arrays.asList("command executed");
    }
}
