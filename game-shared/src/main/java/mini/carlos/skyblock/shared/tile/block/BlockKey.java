package mini.carlos.skyblock.shared.tile.block;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import mini.carlos.skyblock.shared.tile.TileResourceKey;

@RequiredArgsConstructor
public enum BlockKey implements TileResourceKey {

    GRASS(0),
    HALF_GRASS(1),
    DIRT(3),
    HALF_DIRT(4),
    FARM_DIRT(5),
    HALF_FARM_DIRT(6),
    WARM_DIRT(7),
    HALF_WARM_DIRT(8),
    WARM_FARM_DIRT(9),
    HALF_WARM_FARM_DIRT(10),
    WHITE_OUTLINE(11),
    HALF_WHITE_OUTLINE(12),
    BLACK_OUTLINE(13),
    HALF_BLACK_OUTLINE(14);

    @Getter
    private final int id;

    public String getKey(){
        return this.name().toLowerCase();
    }

}
