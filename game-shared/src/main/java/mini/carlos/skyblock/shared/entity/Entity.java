package mini.carlos.skyblock.shared.entity;

import mini.carlos.skyblock.shared.Damageable;
import mini.carlos.skyblock.shared.attribute.Attributable;
import mini.carlos.skyblock.shared.tile.Tile;
import mini.carlos.skyblock.shared.world.Position;

public interface Entity extends Tile, Damageable, Attributable {

    Position getPosition();

}
