package mini.carlos.skyblock.shared.player;

import mini.carlos.skyblock.shared.Damageable;
import mini.carlos.skyblock.shared.attribute.Attributable;
import mini.carlos.skyblock.shared.tile.Tile;

import java.util.UUID;

public interface Player extends Tile, Damageable, Attributable {

    UUID getUuid();

    String getName();

    PlayerInventory getInventory();

}
