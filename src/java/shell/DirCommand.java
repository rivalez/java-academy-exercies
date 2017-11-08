package shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DirCommand implements ShellCommand {

    private final CwdManager cwdManager;

    @Autowired
    public DirCommand(CwdManager cwdManager) {
        this.cwdManager = cwdManager;
    }

    @Override
    public List<String> execute(String[] commandLine) {
        return Arrays.stream(getCwd().listFiles()).map(file -> (file.isDirectory() ? "DIR     " : "FILE    ")
                + file.getName()).collect(Collectors.toList());
    }

    private File getCwd() {
        return cwdManager.getCurrentDir();
    }
}
