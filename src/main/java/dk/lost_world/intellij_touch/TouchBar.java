package dk.lost_world.intellij_touch;

import com.intellij.ide.DataManager;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.ActionPlaces;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.ex.ActionUtil;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.wm.WindowManager;
import com.thizzer.jtouchbar.JTouchBar;
import com.thizzer.jtouchbar.item.TouchBarItem;
import com.thizzer.jtouchbar.item.view.TouchBarButton;
import dk.lost_world.intellij_touch.Button.Button;
import dk.lost_world.intellij_touch.Button.ButtonBuilder;
import dk.lost_world.intellij_touch.Component.SeparatorBuilder;
import jiconfont.icons.FontAwesome;
import jiconfont.swing.IconFontSwing;

import javax.swing.*;

public class TouchBar {

    protected JTouchBar jTouchBar;

    public static TouchBar getInstance() {
        return ServiceManager.getService(TouchBar.class);
    }

    public TouchBar() {
        IconFontSwing.register(FontAwesome.getIconFont());

        jTouchBar = new JTouchBar();
        jTouchBar.setCustomizationIdentifier("intellij-touch");
        jTouchBar.show(WindowManager.getInstance().findVisibleFrame());
    }

    public TouchBar addButton(ButtonBuilder builder) {
        return this.addButton(builder.build());
    }

    public TouchBar addButton(Button button) {
        TouchBarButton touchBarButton = new TouchBarButton();
        touchBarButton.setImage(button.getIcon());
        touchBarButton.setTitle(button.getText());
        touchBarButton.setBezelColor(button.getBezelColor());
        touchBarButton.setAction(touchBarView -> {
            ApplicationManager.getApplication()
                .invokeLater(() -> this.runAction(button.getAction()));
        });
        jTouchBar.addItem(new TouchBarItem(button.getIdentifier(), touchBarButton));

        jTouchBar.show(WindowManager.getInstance().findVisibleFrame());

        return this;
    }

    public TouchBar addSeparator(SeparatorBuilder builder) {
        jTouchBar.addItem(new TouchBarItem(TouchBarItem.NSTouchBarItemIdentifierFixedSpaceSmall));
        return this;
    }


    protected void runAction(AnAction anAction) {
        AnActionEvent anActionEvent = new AnActionEvent(
            null,
            DataManager.getInstance().getDataContextFromFocus().getResult(),
            ActionPlaces.MAIN_MENU,
            anAction.getTemplatePresentation(),
            ActionManager.getInstance(),
            0
        );

        ActionUtil.performDumbAwareUpdate(
            false,
            anAction,
            anActionEvent,
            true
        );

        if (anActionEvent.getPresentation().isEnabled() && anActionEvent.getPresentation().isVisible()) {
            anAction.actionPerformed(anActionEvent);
        }
    }

}
