package dk.lost_world.intellij_touch.Button;

import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.Separator;
import com.thizzer.jtouchbar.common.Image;
import dk.lost_world.intellij_touch.Component.ComponentBuilder;
import dk.lost_world.intellij_touch.TouchBar;
import jiconfont.IconCode;
import jiconfont.swing.IconFontSwing;
import org.jetbrains.annotations.NonNls;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import static com.intellij.util.ui.UIUtil.*;

public class ButtonBuilder extends ComponentBuilder{
    public final int ICON_SIZE = 36;
    public final Color ICON_COLOR = Color.WHITE;
    public final com.thizzer.jtouchbar.common.Color BEZEL_COLOR = com.thizzer.jtouchbar.common.Color.CONTROL_COLOR;
    private String identifier;
    private AnAction action;
    private String title = null;
    private Image icon;
    private com.thizzer.jtouchbar.common.Color bezelColor = BEZEL_COLOR;

    public ButtonBuilder() {
        super();
    }

    public static ButtonBuilder builder() {
        return new ButtonBuilder();
    }

    public Button build()
    {
        return new Button(
            identifier,
            action,
            title,
            icon,
            bezelColor
        );
    }
    
    public ButtonBuilder identifier(String identifier) {
        this.identifier = identifier;
        return this;
    }

    public ButtonBuilder action(AnAction action) {
        this.action = action;
        return this;
    }

    /**
     * @param actionId
     * @return self
     * @see com.intellij.openapi.actionSystem.IdeActions
     */
    public ButtonBuilder action(@NonNls String actionId) {
        AnAction anAction = ActionManager.getInstance().getAction(actionId);
        if(anAction == null) {
            System.out.println("ActionId is invalid:"+actionId);
            throw new IllegalArgumentException("ActionId is invalid.");
        }
        return this.action(anAction);
    }

    public ButtonBuilder title(String title) {
        this.title = title;
        return this;
    }

    public ButtonBuilder icon(Icon icon) {
        return this.icon(iconToImage(icon));
    }

    public ButtonBuilder icon(InputStream imageStream) throws IOException {
        return this.icon(new Image(imageStream));
    }

    public ButtonBuilder icon(Image icon) {
        this.icon = icon;
        return this;
    }

    public ButtonBuilder icon(BufferedImage image) {
        return this.icon(new Image(getImgBytes(image)));
    }

    public ButtonBuilder icon(IconCode iconCode, int size, Color iconColor) {
        java.awt.Image iconImage = IconFontSwing.buildImage(
            iconCode,
            size,
            iconColor
        );
        return this.icon((BufferedImage) iconImage);
    }

    public ButtonBuilder icon(IconCode iconCode, int size) {
        return this.icon(iconCode, size, ICON_COLOR);
    }

    public ButtonBuilder icon(IconCode iconCode, Color iconColor) {
        return this.icon(iconCode, ICON_SIZE, iconColor);
    }

    public ButtonBuilder icon(IconCode iconCode) {
        return this.icon(iconCode, ICON_SIZE, ICON_COLOR);
    }

    public ButtonBuilder bezelColor(com.thizzer.jtouchbar.common.Color color) {
        this.bezelColor = color;
        return this;
    }

    public ButtonBuilder bezelColor(Color color) {
        return this.bezelColor(
            new com.thizzer.jtouchbar.common.Color(
                color.getRed(),
                color.getGreen(),
                color.getBlue(),
                color.getTransparency()
            )
        );
    }

    private byte [] getImgBytes(BufferedImage image) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "PNG", baos);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return baos.toByteArray();
    }

    static BufferedImage iconToImage(Icon icon) {
        BufferedImage image = createImage(
            icon.getIconWidth(),
            icon.getIconHeight(),
            BufferedImage.TYPE_INT_ARGB
        );
        Graphics g = image.createGraphics();
        // paint the Icon to the BufferedImage.
        icon.paintIcon(null, g, 0,0);
        g.dispose();
        return image;
    }

    public void add() {
        this.touchBar.addButton(this);
    }
}
