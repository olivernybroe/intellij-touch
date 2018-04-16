package dk.lost_world.intellij_touch.Actions;

import com.intellij.execution.dashboard.actions.RunAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

public class RunStopAction extends RunAction {

    @Override
    protected void update(@NotNull AnActionEvent e, boolean running) {
        super.update(e, running);

    }
}
