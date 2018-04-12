package dk.lost_world.intellij_touch.Components;

import com.intellij.openapi.actionSystem.ActionGroup;
import dk.lost_world.intellij_touch.TouchBar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TouchBarBuilder {

    protected Collection<ComponentBuilder> components;

    public TouchBarBuilder() {
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
    }

    public void apply() {
        this.apply(TouchBar.getInstance());
    }
}
