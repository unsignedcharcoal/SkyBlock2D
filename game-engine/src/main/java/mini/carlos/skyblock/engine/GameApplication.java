package mini.carlos.skyblock.engine;

import mini.carlos.skyblock.engine.entity.PlayerEngine;

import javax.swing.*;
import java.util.UUID;

public class GameApplication {

    public static void main(String[] args) {
        PlayerEngine engine = new PlayerEngine(UUID.randomUUID(), "Carlinhos");
        SwingUtilities.invokeLater(() -> {
            var frame = new GameFrame();
            GamePanel panel = new GamePanel(engine);
            panel.repaint();

            frame.add(panel);
        });
    }

}
