package dk.lost_world.intellij_touch.Settings;

import com.intellij.ide.ui.customization.CustomizableActionsPanel;
import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SearchableConfigurable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class TouchBarConfigurable implements SearchableConfigurable {

    @Nls
    @Override
    public String getDisplayName() {
        return "Touch Bar";
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        return new TouchBarGUI().getPanel();
    }

    @Override
    public boolean isModified() {
        return false;
    }

    @Override
    public void apply() throws ConfigurationException {

    }

    @NotNull
    @Override
    public String getId() {
        return "preferences.intellij-touch";
    }
}
