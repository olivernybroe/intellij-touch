package dk.lost_world.intellij_touch.Components;

import com.intellij.ide.ui.customization.CustomisedActionGroup;
import com.intellij.openapi.actionSystem.ActionGroup;
import com.intellij.openapi.actionSystem.AnAction;
import com.thizzer.jtouchbar.item.TouchBarItem;
import dk.lost_world.intellij_touch.TouchBar;

import java.util.ArrayList;
import java.util.Collection;

public class PopoverBuilder extends ComponentBuilder<PopoverBuilder> {

    protected Collection<ComponentBuilder> components;
    protected TouchBarBuilder childTouchBar;

    public PopoverBuilder() {
        this.components = new ArrayList<>();
    }

    @Override
    public PopoverBuilder fromAnAction(AnAction action) {
        if(!(action instanceof CustomisedActionGroup)) {
            throw new IllegalArgumentException("Popovers can only be generated from CustomisedActionGroups.");
        }
        //childTouchBar = TouchBarBuilder.fromAction((ActionGroup) action);
        return this;
    }

    @Override
    public void add() {
        /*
        PopoverTouchBarItem popover = new PopoverTouchBarItem(this.identifier);

        popover.setPopoverTouchBar(
            childTouchBar.build(
                this.touchBar.project(),
                this.identifier
            ).jTouchBar()
        );
        */

       //this.touchBar.addItem(popover);
    }
}
