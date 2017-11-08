package shell;

import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Arrays;
import java.util.List;


//BeanPostProcessor
@Component
@ShellCommandImplementation()
public class CdCommand implements ShellCommand {

    private CwdManager cwdManager;

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
