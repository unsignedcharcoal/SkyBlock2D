package mini.carlos.skyblock.shared.tile.block;

import mini.carlos.skyblock.shared.Drawable;
import mini.carlos.skyblock.shared.tile.TileResource;

public class BlockResource extends TileResource<BlockKey> {

    protected static String DIRT = "dirt";
    protected static String OUTLINE = "outline";

    public BlockResource() {
        super(Drawable.TILE_SIZE, Drawable.TILE_SIZE, Drawable.TILE_GRID, Drawable.TILE_PADDING, Drawable.TILE_PADDING);

        registerSheet(DIRT, TileResource.BLOCKS_URL + "dirt_blocks.png");
        registerSheet(OUTLINE, TileResource.BLOCKS_URL + "block_outlines.png");
    }

    @Override
    public void registerTiles() {
        registerTile(DIRT, BlockKey.GRASS, 0, 0);
        registerTile(DIRT, BlockKey.DIRT, 1, 0);
        registerTile(DIRT, BlockKey.FARM_DIRT, 2, 0);
        registerTile(DIRT, BlockKey.WARM_DIRT, 3, 0);
        registerTile(DIRT, BlockKey.WARM_FARM_DIRT, 4, 0);

        registerTile(DIRT, BlockKey.HALF_GRASS, 0, 1);
        registerTile(DIRT, BlockKey.HALF_DIRT, 1, 1);
        registerTile(DIRT, BlockKey.HALF_FARM_DIRT, 2, 1);
        registerTile(DIRT, BlockKey.HALF_WARM_DIRT, 3, 1);
        registerTile(DIRT, BlockKey.HALF_WARM_FARM_DIRT, 4, 1);

        registerTile(OUTLINE, BlockKey.WHITE_OUTLINE, 0, 0);
        registerTile(OUTLINE, BlockKey.HALF_WHITE_OUTLINE, 0, 1);
        registerTile(OUTLINE, BlockKey.BLACK_OUTLINE, 1, 0);
        registerTile(OUTLINE, BlockKey.HALF_BLACK_OUTLINE, 1, 1);

    }
}
