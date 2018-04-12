package dk.lost_world.intellij_touch;

import com.intellij.ide.ui.customization.CustomActionsSchema;
import com.intellij.ide.ui.customization.CustomisedActionGroup;
import com.intellij.openapi.actionSystem.ActionGroup;
import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.WindowManager;
import dk.lost_world.intellij_touch.Components.ComponentBuilder;
import dk.lost_world.intellij_touch.Components.TouchBarBuilder;

import java.util.stream.Stream;

public class TouchBarProjectComponent implements ProjectComponent {

    protected Project project;

    public TouchBarProjectComponent(Project project) {
        this.project = project;
    }

    @Override
    public void projectOpened() {
        TouchBar touchBar = TouchBar.getInstance(project);

        ActionGroup touchBarGroup = (ActionGroup)
            CustomActionsSchema.getInstance().getCorrectedAction("dk.lost_world.intellij_touch.TouchBar");

        // Add all the buttons to the Touch bar.
        TouchBarBuilder.fromAction(touchBarGroup).apply(touchBar);
    }
}
