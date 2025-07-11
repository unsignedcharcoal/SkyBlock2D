package mini.carlos.skyblock.shared.tile.flag;

import org.jetbrains.annotations.NotNull;

public interface TileFlag {

    long getFlags();

    default boolean hasFlag(@NotNull BitFlag flag) {
        return (getFlags() & flag.getBit()) != 0;
    }

}
