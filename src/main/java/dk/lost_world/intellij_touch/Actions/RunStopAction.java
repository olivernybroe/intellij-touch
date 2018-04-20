package dk.lost_world.intellij_touch.Actions;

import com.intellij.execution.ExecutionManager;
import com.intellij.execution.ExecutionTargetManager;
import com.intellij.execution.Executor;
import com.intellij.execution.dashboard.RunDashboardManager;
import com.intellij.execution.dashboard.RunDashboardRunConfigurationNode;
import com.intellij.execution.dashboard.actions.RunAction;
import com.intellij.execution.executors.DefaultRunExecutor;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.execution.ui.RunContentDescriptor;
import com.intellij.execution.ui.RunContentManagerImpl;
import com.intellij.icons.AllIcons;
import com.intellij.ide.DataManager;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.ui.content.Content;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class RunStopAction extends AnAction {

    public RunStopAction() {
        super(AllIcons.Actions.Execute);
    }

    protected Executor getExecutor() {
        return DefaultRunExecutor.getRunExecutorInstance();
    }

    @Override
    public void actionPerformed(AnActionEvent e) {
        Project project = e.getProject();
        if (project == null) {
            return;
        }

        Content content = RunDashboardManager.getInstance(project).getDashboardContentManager().getSelectedContent();
        if (content != null) {
            RunContentDescriptor descriptor = RunContentManagerImpl.getRunContentDescriptorByContent(content);
            JComponent component = content.getComponent();
            if (component == null) {
                return;
            }
            ExecutionEnvironment environment = LangDataKeys.EXECUTION_ENVIRONMENT.getData(DataManager.getInstance().getDataContext(component));
            if (environment == null) {
                return;
            }
            ExecutionManager.getInstance(project).restartRunProfile(project,
                getExecutor(),
                ExecutionTargetManager.getActiveTarget(project),
                environment.getRunnerAndConfigurationSettings(),
                descriptor == null ? null : descriptor.getProcessHandler());
        }
    }

    @Override
    public void update(AnActionEvent e) {
        super.update(e);
    }
}
