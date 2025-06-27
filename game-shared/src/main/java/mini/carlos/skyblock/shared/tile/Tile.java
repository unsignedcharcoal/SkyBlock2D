package mini.carlos.skyblock.shared.tile;

import mini.carlos.skyblock.shared.world.Position;
import org.jetbrains.annotations.NotNull;

public interface Tile {

    Position getPosition();

    TileSprite getSprite();

    long getFlags();

    default boolean hasFlag(@NotNull TileFlag flag) {
        return (getFlags() & flag.getBit()) != 0;
    }
}
