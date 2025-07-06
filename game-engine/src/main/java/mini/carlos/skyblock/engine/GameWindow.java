package mini.carlos.skyblock.engine;

import javax.swing.*;

public class GameWindow extends JFrame {

    public GameWindow(GamePanel panel) {
        setTitle("SkyBlock Engine");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        add(panel);
        pack(); // preferredSize by canvas
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
