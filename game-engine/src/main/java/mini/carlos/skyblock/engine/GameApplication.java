package mini.carlos.skyblock.engine;

import mini.carlos.skyblock.engine.entity.PlayerEngine;

import javax.swing.*;
import java.util.UUID;

public class GameApplication {

    public static void main(String[] args) {
        PlayerEngine playerEngine = new PlayerEngine(UUID.randomUUID(), "Carlinhos");
        SwingUtilities.invokeLater(() -> {
            GamePanel gamePanel = new GamePanel(playerEngine);
            GameWindow window = new GameWindow(gamePanel);

            gamePanel.startGame();
        });
    }

}
