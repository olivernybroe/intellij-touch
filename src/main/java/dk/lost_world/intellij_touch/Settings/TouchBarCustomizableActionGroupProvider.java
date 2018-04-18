package dk.lost_world.intellij_touch.Settings;

import com.intellij.ide.ui.customization.CustomActionsSchema;
import com.intellij.ide.ui.customization.CustomizableActionGroupProvider;
import com.intellij.openapi.actionSystem.ActionGroup;

public class TouchBarCustomizableActionGroupProvider extends CustomizableActionGroupProvider {
    @Override
    public void registerGroups(CustomizableActionGroupRegistrar registrar) {
        registrar.addCustomizableActionGroup("dk.lost_world.intellij_touch.TouchBar", "Touch Bar");
    }

    public static ActionGroup getTouchBarSchema() {
        return (ActionGroup) CustomActionsSchema.getInstance().getCorrectedAction("dk.lost_world.intellij_touch.TouchBar");
    }
}
