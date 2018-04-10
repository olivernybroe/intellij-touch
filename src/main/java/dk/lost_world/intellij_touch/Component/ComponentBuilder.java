package dk.lost_world.intellij_touch.Component;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.Separator;
import dk.lost_world.intellij_touch.Button.ButtonBuilder;
import dk.lost_world.intellij_touch.TouchBar;

public abstract class ComponentBuilder {

    protected TouchBar touchBar;

    public ComponentBuilder(TouchBar touchBar) {
        this.touchBar = touchBar;
    }

    public ComponentBuilder() {
        this(TouchBar.getInstance());
    }

    public static ComponentBuilder fromAction(AnAction anAction) {
        if(anAction instanceof Separator) {
            return new SeparatorBuilder();
        }

        if(anAction.getTemplatePresentation().getText() == null && anAction.getTemplatePresentation().getIcon() == null) {
            throw new RuntimeException("Invalid action.");
        }

        ButtonBuilder builder = new ButtonBuilder();

        if(anAction.getTemplatePresentation().getIcon() == null) {
            builder.title(anAction.getTemplatePresentation().getText());
        }
        else {
            builder.icon(anAction.getTemplatePresentation().getIcon());
        }
        builder.action(anAction);
        builder.identifier(anAction.toString());
        return builder;
    }


    public abstract void add();
}
