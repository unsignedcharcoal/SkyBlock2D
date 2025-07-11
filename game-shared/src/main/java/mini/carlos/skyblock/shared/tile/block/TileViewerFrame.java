package mini.carlos.skyblock.shared.tile.block;

import mini.carlos.skyblock.shared.tile.Tile;
import mini.carlos.skyblock.shared.tile.TileResource;
import mini.carlos.skyblock.shared.tile.TileResourceKey;

import javax.swing.*;
import java.awt.*;

public class TileViewerFrame<Key extends TileResourceKey> extends JFrame {

    public TileViewerFrame(TileResource<Key> resource, Key keyToDisplay) {
        setTitle("Tile Viewer - " + keyToDisplay.getKey());
        setSize(128, 128);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Tile tile = resource.getTile(keyToDisplay);

        if (tile == null || tile.getSprite().image() == null) {
            JLabel errorLabel = new JLabel("Tile not found!", SwingConstants.CENTER);
            add(errorLabel);
            return;
        }

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image img = tile.getSprite().image().getScaledInstance(128, 128, Image.SCALE_SMOOTH);
                g.drawImage(img, (getWidth() - img.getWidth(null)) / 2, (getHeight() - img.getHeight(null)) / 2, null);
            }
        };

        add(panel);
    }
}
