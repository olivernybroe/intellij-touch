package dk.lost_world.intellij_touch.Icons;

import jiconfont.IconCode;
import jiconfont.IconFont;
import jiconfont.icons.FontAwesome;

import java.io.InputStream;

public enum FontAwesomePro implements IconCode {
    CODE_COMMIT('\uF386')
    ;

    private final char character;

    FontAwesomePro(char character) {
        this.character = character;
    }

    @Override
    public char getUnicode() {
        return character;
    }

    @Override
    public String getFontFamily() {
        return "FontAwesome";
    }

    public static IconFont getIconFont() {
        return new IconFont() {
            @Override
            public String getFontFamily() {
                return "FontAwesome";
            }

            @Override
            public InputStream getFontInputStream() {
                return FontAwesome.class.getResourceAsStream("/fonts/Font Awesome 5 Pro-Light-300.otf");
            }
        };
    }
}
