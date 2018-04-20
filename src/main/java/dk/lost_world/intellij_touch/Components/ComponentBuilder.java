package dk.lost_world.intellij_touch.Components;

import com.intellij.execution.ExecutorRegistry;
import com.intellij.ide.DataManager;
import com.intellij.ide.ui.customization.CustomisedActionGroup;
import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.actionSystem.ex.ActionManagerEx;
import com.intellij.openapi.actionSystem.ex.ActionUtil;
import com.intellij.openapi.application.ApplicationManager;
import dk.lost_world.intellij_touch.TouchBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import static java.awt.event.ComponentEvent.COMPONENT_FIRST;

public abstract class ComponentBuilder<BUILDER extends ComponentBuilder> {

    protected TouchBar touchBar;

    protected String identifier;

    public ComponentBuilder(TouchBar touchBar) {
        this.touchBar = touchBar;
    }

    public ComponentBuilder() {}

    public ComponentBuilder touchBar(TouchBar touchBar) {
         this.touchBar = touchBar;
         return this;
    }

    public ComponentBuilder identifier(String identifier) {
        this.identifier = identifier;
        return this;
    }

    public static ComponentBuilder fromAction(AnAction anAction) {
        if(anAction instanceof Separator) {
            return new SeparatorBuilder().fromAnAction(anAction);
        }
        else if(anAction instanceof CustomisedActionGroup) {
            return new PopoverBuilder().fromAnAction(anAction);
        }
        else {
            return new ButtonBuilder().fromAnAction(anAction);
        }
    }

    public abstract BUILDER fromAnAction(AnAction action);

    public abstract void add();

    protected void runAction(AnAction anAction) {


        final ActionManagerEx actionManagerEx = ActionManagerEx.getInstanceEx();
        final KeyboardFocusManager focusManager=KeyboardFocusManager.getCurrentKeyboardFocusManager();
        final Component focusOwner = focusManager.getFocusedWindow();

        final InputEvent ie = new KeyEvent(focusOwner, COMPONENT_FIRST, System.currentTimeMillis(), 0, 0, '\0');
        actionManagerEx.tryToExecute(anAction, ie, focusOwner, ActionPlaces.TOOLBAR, false);
    }
}
