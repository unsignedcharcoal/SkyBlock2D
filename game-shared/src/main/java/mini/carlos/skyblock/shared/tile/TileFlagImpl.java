package mini.carlos.skyblock.shared.tile;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.EnumSet;
import java.util.Set;

@RequiredArgsConstructor
public enum TileFlagImpl implements TileFlag {

    PLACEABLE(TileFlagBitMask.PLACEABLE),
    BREAKABLE(TileFlagBitMask.BREAKABLE),
    LIQUID(TileFlagBitMask.LIQUID);

    private final long bit;

    public static Set<TileFlagImpl> getFlagsFromMask(long mask) {
        EnumSet<TileFlagImpl> set = EnumSet.noneOf(TileFlagImpl.class);
        for (TileFlagImpl flag : TileFlagImpl.values()) {
            if ((mask & flag.getBit()) != 0) {
                set.add(flag);
            }
        }
        return set;
    }

    @Override
    public long getBit() {
        return bit;
    }
}
