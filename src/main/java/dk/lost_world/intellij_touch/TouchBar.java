package dk.lost_world.intellij_touch;

import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.wm.WindowManager;
import com.thizzer.jtouchbar.JTouchBar;
import com.thizzer.jtouchbar.common.Color;
import com.thizzer.jtouchbar.item.TouchBarItem;
import com.thizzer.jtouchbar.item.view.TouchBarButton;
import com.thizzer.jtouchbar.item.view.TouchBarTextField;
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

    public void addItem(TouchBarItem touchBarItem) {
        this.jTouchBar.addItem(touchBarItem);
        jTouchBar.show(WindowManager.getInstance().findVisibleFrame());
    }
}
