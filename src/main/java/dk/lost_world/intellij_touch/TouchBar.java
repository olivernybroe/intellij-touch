package dk.lost_world.intellij_touch;

import com.intellij.ide.ui.customization.CustomActionsSchema;
import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.actionSystem.ex.AnActionListener;
import com.intellij.openapi.actionSystem.impl.PresentationFactory;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.ModalityState;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.WindowManager;
import com.thizzer.jtouchbar.JTouchBar;
import com.thizzer.jtouchbar.common.Color;
import com.thizzer.jtouchbar.common.Image;
import com.thizzer.jtouchbar.common.ImageName;
import com.thizzer.jtouchbar.item.PopoverTouchBarItem;
import com.thizzer.jtouchbar.item.TouchBarItem;
import com.thizzer.jtouchbar.item.view.TouchBarButton;
import com.thizzer.jtouchbar.item.view.TouchBarTextField;
import dk.lost_world.intellij_touch.Components.TouchBarBuilder;
import dk.lost_world.intellij_touch.Settings.TouchBarCustomizableActionGroupProvider;
import jiconfont.icons.FontAwesome;
import jiconfont.swing.IconFontSwing;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.*;
import java.util.stream.Collectors;

import static com.intellij.openapi.application.ModalityState.NON_MODAL;

public class TouchBar {

    protected JTouchBar jTouchBar;

    protected Project project;

    protected Collection<ItemListener> itemListeners;

    protected Frame touchBarFrame;

    public static TouchBar getInstance(Project project) {
        return ServiceManager.getService(project, TouchBar.class);
    }

    public TouchBar(Project project) {
        this(project, "");
    }

    public TouchBar(Project project, String identifier) {
        this.itemListeners = new ArrayList<>();
        this.project = project;
        this.touchBarFrame = WindowManager.getInstance().getFrame(this.project);
        IconFontSwing.register(FontAwesome.getIconFont());

        jTouchBar = createJTouchBar(identifier);
        jTouchBar.show(this.touchBarFrame);

        ActionManager.getInstance().addAnActionListener((action, dataContext, event) -> {
            Collection<ItemListener> listeners = itemListeners.stream()
                .filter(_itemListener -> _itemListener.getActionId()
                    .equals(ActionManager.getInstance().getId(action)))
                        .collect(Collectors.toList());

            listeners.forEach(itemListener -> {
                event.getPresentation().addPropertyChangeListener(
                    itemListener.getPropertyChangeListener()
                );
                itemListeners.remove(itemListener);
            });
        });
    }

    public void addItem(TouchBarItem touchBarItem) {
        this.jTouchBar.addItem(touchBarItem);
    }

    public void addItemListener(ItemListener listener) {
        this.itemListeners.add(listener);
    }

    public Project project() {
        return this.project;
    }

    public JTouchBar jTouchBar() {
        return this.jTouchBar;
    }

    public void refresh() {
        jTouchBar.setItems(null);
        ActionGroup touchBarGroup = TouchBarCustomizableActionGroupProvider.getTouchBarSchema();

        // Add all the buttons to the Touch bar.
        TouchBarBuilder.fromAction(touchBarGroup).apply(this);
    }

    public void show() {
        jTouchBar.show(this.touchBarFrame);
    }

    protected JTouchBar createJTouchBar(String identifier) {
        jTouchBar = new JTouchBar();
        jTouchBar.setCustomizationIdentifier("intellij-touch:"+identifier+":"+UUID.randomUUID().toString());
        return jTouchBar;
    }

    public void destroy() {
        jTouchBar.hide(this.touchBarFrame);
        String identifier = jTouchBar.getCustomizationIdentifier();
        jTouchBar = new JTouchBar();
        jTouchBar.setCustomizationIdentifier(identifier);
    }

    public interface ItemListener {
        String getActionId();
        PropertyChangeListener getPropertyChangeListener();
    }
}
