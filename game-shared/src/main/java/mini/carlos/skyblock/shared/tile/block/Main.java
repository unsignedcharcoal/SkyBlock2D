package mini.carlos.skyblock.shared.tile.block;

import mini.carlos.skyblock.shared.block.BlockKey;
import mini.carlos.skyblock.shared.block.BlockResource;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        BlockResource resource = new BlockResource();

        SwingUtilities.invokeLater(() -> {
            TileViewerFrame<BlockKey> viewer = new TileViewerFrame<>(resource, BlockKey.BLACK_OUTLINE);
            viewer.setVisible(true);
        });
    }
}
