package dk.lost_world.intellij_touch.Component;

public class SeparatorBuilder extends ComponentBuilder {

    @Override
    public void add() {
        this.touchBar.addSeparator(this);
    }
}
