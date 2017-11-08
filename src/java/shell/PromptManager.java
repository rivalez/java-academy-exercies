package shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PromptManager {

    private final CwdManager cwdManager;
    boolean shouldDisplayCwd = false;

    @Autowired
    public PromptManager(CwdManager cwdManager) {
        this.cwdManager = cwdManager;
    }

    public void setPromptCwd() {
        shouldDisplayCwd = true;
    }

    public String getPrompt(){
        return shouldDisplayCwd ? cwdManager.getCurrentDir().getAbsolutePath() : "?>";
    }
}
