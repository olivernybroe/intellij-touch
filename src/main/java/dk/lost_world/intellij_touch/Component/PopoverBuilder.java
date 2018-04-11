package dk.lost_world.intellij_touch.Component;

import com.intellij.ide.ui.customization.CustomisedActionGroup;
import com.intellij.openapi.actionSystem.AnAction;
import com.thizzer.jtouchbar.item.GroupTouchBarItem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PopoverBuilder extends ComponentBuilder<PopoverBuilder> {

    protected Collection<ComponentBuilder> components;

    public PopoverBuilder() {
        this.components = new ArrayList<>();
    }

    @Override
    public PopoverBuilder fromAnAction(AnAction action) {
        if(!(action instanceof CustomisedActionGroup)) {
            throw new IllegalArgumentException("Popovers can only be generated from CustomisedActionGroups.");
        }

        //TODO: can't implement until issue Thizzers has support for it. #5
        return this;
    }

    @Override
    public void add() {

    }
}
