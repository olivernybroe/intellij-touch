package dk.lost_world.intellij_touch.Components;

import com.intellij.openapi.actionSystem.ActionGroup;
import com.intellij.openapi.project.Project;
import com.thizzer.jtouchbar.item.TouchBarItem;
import com.thizzer.jtouchbar.item.view.TouchBarTextField;
import dk.lost_world.intellij_touch.TouchBar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TouchBarBuilder {

    protected Collection<ComponentBuilder> components;

    protected TouchBarBuilder() {
        components = new ArrayList<>();
    }

    public static TouchBarBuilder fromAction(ActionGroup actionGroup) {
        TouchBarBuilder touchBarBuilder = new TouchBarBuilder();

        touchBarBuilder.components.addAll(
            Stream.of(actionGroup.getChildren(null)).map(ComponentBuilder::fromAction).collect(Collectors.toList())
        );

        return touchBarBuilder;
    }

    public void apply(TouchBar touchBar) {
        components.forEach(componentBuilder -> componentBuilder.touchBar(touchBar).add());
        touchBar.show();
    }

    public TouchBar build(Project project, String identifier) {
        return new TouchBar(project, identifier);
    }
}
