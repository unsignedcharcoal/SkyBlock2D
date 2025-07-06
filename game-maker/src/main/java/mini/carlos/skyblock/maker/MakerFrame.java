package mini.carlos.skyblock.maker;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.util.Objects;

public class MakerFrame extends JFrame {

    public MakerFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("SkyBlock Game Maker");
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        try {
            setIconImage(ImageIO.read(
                    Objects.requireNonNull(getClass().getResourceAsStream("/icons/game-icon-maker.png"))
            ));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
