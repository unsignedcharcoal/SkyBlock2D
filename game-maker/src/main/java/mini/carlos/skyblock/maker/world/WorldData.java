package mini.carlos.skyblock.maker.world;

import lombok.Getter;
import mini.carlos.skyblock.shared.tile.Tile;
import mini.carlos.skyblock.shared.world.Position3D;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

@Getter
public class WorldData {

    private final int size;
    private final Map<Position3D, Tile> tiles = new HashMap<>();

    public WorldData(int size) {
        this.size = size;
    }

    public void setTile(int x, int y, int z, Tile tile) {
        Position3D pos = new Position3D(x, y, z);
        if (tile == null) {
            tiles.remove(pos);
        } else {
            tiles.put(pos, tile);
        }
    }

    public Tile getTile(int x, int y, int z) {
        return tiles.get(new Position3D(x, y, z));
    }

    public Tile getTile(Position3D pos) {
        return tiles.get(pos);
    }

    public void generateGrid(Tile block) {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                for (int z = 0; z < size; z++) {
                    setTile(x, y, z, block);
                }
            }
        }
    }

    public void fetchTiles(BiConsumer<Position3D, Tile> consumer) {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                for (int z = 0; z < size; z++) {
                    Tile tile = getTile(x, y, z);
                    if  (tile != null) {
                        consumer.accept(new Position3D(x, y, z), tile);
                    }
                }
            }
        }
    }

}
