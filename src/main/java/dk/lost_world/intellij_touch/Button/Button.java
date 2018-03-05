package dk.lost_world.intellij_touch.Button;

import com.intellij.openapi.actionSystem.AnAction;
import com.thizzer.jtouchbar.common.Color;
import com.thizzer.jtouchbar.common.Image;
import org.jetbrains.annotations.Nullable;

import java.awt.image.BufferedImage;

public class Button {
    protected String identifier;
    protected AnAction action;
    protected String text;
    protected Image icon;
    protected Color bezelColor;

    public Button(String identifier, AnAction action, @Nullable String text, Image icon, Color bezelColor) {
        this.identifier = identifier;
        this.action = action;
        this.text = text;
        this.icon = icon;
        this.bezelColor = bezelColor;
    }

    public String getIdentifier() {
        return identifier;
    }

    public AnAction getAction() {
        return action;
    }

    public String getText() {
        return text;
    }

    public Image getIcon() {
        return icon;
    }

    public Color getBezelColor() {
        return bezelColor;
    }
}
