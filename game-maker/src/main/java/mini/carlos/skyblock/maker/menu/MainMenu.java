package mini.carlos.skyblock.maker.menu;

import mini.carlos.skyblock.maker.MakerApplication;
import mini.carlos.skyblock.maker.gfx.Resource;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MainMenu {

    public static void startMenu(JFrame frame) {
        createCenterBar(frame);
    }

    private static void createCenterBar(JFrame frame){
        //Background
        JPanel mainPanel = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                Graphics2D g2d = (Graphics2D) g;
                int width = getWidth();
                int height = getHeight();

                GradientPaint gradient = new GradientPaint(0, 0, Color.BLACK, width, height, Color.WHITE);
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, width, height);
            }
        };

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;

        ImageIcon icon = new ImageIcon(MakerApplication.iconLocal());
        var scaled = icon.getImage().getScaledInstance(128, 128, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(scaled));
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
        buttonPanel.add(imageLabel, gbc);

        gbc.gridheight = 1;
        gbc.gridy = 2;
        buttonPanel.add(new JButton("Create World"), gbc);

        gbc.gridy++;
        buttonPanel.add(new JButton("Load World"), gbc);

        gbc.gridy++;
        buttonPanel.add(new JButton("Leave"), gbc);

        mainPanel.add(buttonPanel);
        frame.setContentPane(mainPanel);

    }

    private static class WoodenButton {

        private final BufferedImage startPart;
        private final BufferedImage centerPart;
        private final BufferedImage endPart;

        public WoodenButton(){
            startPart = Resource.loadTiles();
            centerPart = null;
            endPart = null;
        };

    }


}
