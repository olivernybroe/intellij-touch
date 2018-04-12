package dk.lost_world.intellij_touch.Components;

import com.intellij.openapi.actionSystem.AnAction;
import com.thizzer.jtouchbar.item.TouchBarItem;

public class SeparatorBuilder extends ComponentBuilder<SeparatorBuilder> {

    @Override
    public SeparatorBuilder fromAnAction(AnAction action) {
        return this;
    }

    @Override
    public void add() {
        this.touchBar.addItem(new TouchBarItem(TouchBarItem.NSTouchBarItemIdentifierFixedSpaceSmall));
    }
}
