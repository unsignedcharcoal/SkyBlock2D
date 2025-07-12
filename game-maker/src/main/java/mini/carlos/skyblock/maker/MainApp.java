package mini.carlos.skyblock.maker;

import mini.carlos.skyblock.shared.block.BlockResource;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class MainApp {

    public static void main(String[] args) {
        new BlockResource();
        createApp();
    }

    private static void createApp() {
        MainFrame frame = new MainFrame();
        MainMenu.startMenu(frame);
        frame.setVisible(true);
    }

    private static void createLayout(MainFrame frame) {
        JPanel boxPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(boxPanel, BoxLayout.Y_AXIS);
        boxPanel.setLayout(boxLayout);

        for (int i = 0; i < 5; i++) {
            JLabel label = new JLabel("Value " + i);
            boxPanel.add(label);
        }

        frame.add(boxPanel);
    }

    private static class MainFrame extends JFrame {

        public MainFrame() {
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setTitle("Sky Block Game Maker");
            setSize(800, 600);
            setResizable(true);
            setLocationRelativeTo(null);
            setVisible(true);
            setLayout(null);

            setIconImage(iconLocal());
        }
    }

    public static BufferedImage iconLocal() {
        try {
            return ImageIO.read(Objects.requireNonNull(MainApp.class.getResourceAsStream("/icons/game-icon-maker.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
