package shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Arrays;
import java.util.List;


@Component
public class CdCommand implements ShellCommand {

    private final CwdManager cwdManager;

    @Autowired
    public CdCommand(CwdManager cwdManager) {
        this.cwdManager = cwdManager;
    }

    @Override
    public List<String> execute(String[] commandLine) {
        File cwd = cwdManager.getCurrentDir();
        File parent = cwd.getParentFile();
        cwdManager.setCurrentDir(parent);

        return Arrays.asList("Directory was changed");
    }
}
