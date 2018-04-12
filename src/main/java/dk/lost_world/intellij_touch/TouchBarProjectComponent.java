package dk.lost_world.intellij_touch;

import com.intellij.ide.ui.customization.CustomActionsSchema;
import com.intellij.ide.ui.customization.CustomisedActionGroup;
import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.components.ProjectComponent;
import dk.lost_world.intellij_touch.Components.TouchBarBuilder;

public class TouchBarProjectComponent implements ProjectComponent {

    @Override
    public void initComponent() {
        TouchBar touchBar = TouchBar.getInstance();

        ActionGroup touchBarGroup = (ActionGroup)
            CustomActionsSchema.getInstance().getCorrectedAction("dk.lost_world.intellij_touch.TouchBar");

        // Add all the buttons to the Touch bar.
        TouchBarBuilder.fromAction(touchBarGroup).apply();
    }
}
