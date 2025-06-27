package mini.carlos.skyblock.shared.item;

import mini.carlos.skyblock.shared.tile.TileFlag;
import org.jetbrains.annotations.NotNull;

public interface Item  {

    long getFlags();

    default boolean hasFlag(@NotNull TileFlag flag) {
        return (getFlags() & flag.getBit()) != 0;
    }

}
