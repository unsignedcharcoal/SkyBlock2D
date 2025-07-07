package mini.carlos.skyblock.maker;

import javax.swing.*;

public class MakerApplication {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MakerFrame frame = new MakerFrame();
            MakerPanel panel = new MakerPanel();

            frame.add(panel);
            frame.setVisible(true);
        });
    }
}
