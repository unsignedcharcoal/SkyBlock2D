package mini.carlos.skyblock.maker.commons;

import javax.swing.*;
import java.awt.*;

public class MakerButton {

    public static final Color BUTTON_BACKGROUND_COLOR = new Color(210, 210, 210);
    public static final Color BUTTON_BORDER_COLOR = new Color(160, 160, 160);

    public static JButton create(String text) {
        return  new RoundedButton(
                text,
                12,
                BUTTON_BACKGROUND_COLOR,    // background
                BUTTON_BORDER_COLOR         // border
        );
    }
}
