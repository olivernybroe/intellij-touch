package dk.lost_world.intellij_touch.Components;

import com.intellij.icons.AllIcons;
import com.intellij.ide.ui.customization.CustomisedActionGroup;
import com.intellij.openapi.actionSystem.ActionGroup;
import com.intellij.openapi.actionSystem.AnAction;
import com.thizzer.jtouchbar.JTouchBar;
import com.thizzer.jtouchbar.common.Color;
import com.thizzer.jtouchbar.common.Image;
import com.thizzer.jtouchbar.common.ImageName;
import com.thizzer.jtouchbar.item.PopoverTouchBarItem;
import com.thizzer.jtouchbar.item.TouchBarItem;
import com.thizzer.jtouchbar.item.view.TouchBarButton;
import dk.lost_world.intellij_touch.TouchBar;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;

public class PopoverBuilder extends ComponentBuilder<PopoverBuilder> {

    protected Collection<ComponentBuilder> components;
    protected TouchBarBuilder childTouchBar;
    protected Image icon;

    public PopoverBuilder() {
        this.components = new ArrayList<>();
    }

    @Override
    public PopoverBuilder fromAnAction(AnAction action) {
        if(!(action instanceof CustomisedActionGroup)) {
            throw new IllegalArgumentException("Popovers can only be generated from CustomisedActionGroups.");
        }
        //childTouchBar = TouchBarBuilder.fromAction((ActionGroup) action);
        this.identifier(action.toString());
        return this;
    }

    @Override
    public void add() {
/*
        System.out.println("yep");
        PopoverTouchBarItem popover = new PopoverTouchBarItem("popover");
        popover.setCollapsedRepresentationLabel("bla bla");

        JTouchBar inner = new JTouchBar();
        inner.setCustomizationIdentifier("innerTouch");
        TouchBarButton innerButton = new TouchBarButton();
        innerButton.setBezelColor(Color.CONTROL_COLOR);
        innerButton.setImage(new Image(ImageName.NSImageNameTouchBarColorPickerFill, false));
        inner.addItem(new TouchBarItem("button_1", innerButton));
        popover.setPopoverTouchBar(inner);
*/

        /*
        popover.setPopoverTouchBar(
            childTouchBar.build(
                this.touchBar.project(),
                this.identifier
            ).jTouchBar()
        );
        */

//       this.touchBar.addItem(popover);
    }
}
