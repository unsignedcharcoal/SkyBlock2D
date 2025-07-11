package mini.carlos.skyblock.shared.tile.block;

import mini.carlos.skyblock.shared.tile.TileResource;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        BlockResource resource = new BlockResource();
        resource.registerTiles();

        SwingUtilities.invokeLater(() -> {
            TileViewerFrame<BlockKey> viewer = new TileViewerFrame<>(resource, BlockKey.BLACK_OUTLINE);
            viewer.setVisible(true);
        });
    }
}
