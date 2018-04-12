package dk.lost_world.intellij_touch.Components;

import com.intellij.execution.ExecutorRegistry;
import com.intellij.ide.DataManager;
import com.intellij.ide.ui.customization.CustomisedActionGroup;
import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.actionSystem.ex.ActionUtil;
import dk.lost_world.intellij_touch.TouchBar;

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
