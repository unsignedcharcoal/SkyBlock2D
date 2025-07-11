package mini.carlos.skyblock.shared.tile.flag;

import lombok.RequiredArgsConstructor;

import java.util.EnumSet;
import java.util.Set;

@RequiredArgsConstructor
public enum BitFlagImpl implements BitFlag {

    PLACEABLE(BitFlagMask.PLACEABLE),
    BREAKABLE(BitFlagMask.BREAKABLE),
    LIQUID(BitFlagMask.LIQUID);

    private final long bit;

    public static Set<BitFlagImpl> getFlagsFromMask(long mask) {
        EnumSet<BitFlagImpl> set = EnumSet.noneOf(BitFlagImpl.class);
        for (BitFlagImpl flag : BitFlagImpl.values()) {
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
