package shell;

import java.util.List;

public interface ShellCommand {
    List<String> execute(String[] commandLine);
}
