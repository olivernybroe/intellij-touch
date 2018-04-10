package dk.lost_world.intellij_touch.Settings;

import com.intellij.ide.ui.customization.CustomizableActionGroupProvider;

public class TouchBarCustomizableActionGroupProvider extends CustomizableActionGroupProvider {
    @Override
    public void registerGroups(CustomizableActionGroupRegistrar registrar) {
        registrar.addCustomizableActionGroup("dk.lost_world.intellij_touch.TouchBar", "Touch Bar");
    }
}
