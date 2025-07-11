package mini.carlos.skyblock.shared.tile;

import java.awt.*;

public interface TileSprite {

    Image image();

    default boolean isAnimated() { return false; }

    default Image[] frames() { return null; }

}
