package mini.carlos.skyblock.shared.block;

import mini.carlos.skyblock.shared.Damageable;
import mini.carlos.skyblock.shared.entity.Entity;
import mini.carlos.skyblock.shared.item.Item;
import mini.carlos.skyblock.shared.player.Player;
import mini.carlos.skyblock.shared.tile.Tile;
import mini.carlos.skyblock.shared.world.Direction;

import java.util.List;

public interface Block extends Tile, Damageable {

    void interactEntity(Entity entity);

    void interactPlayer(Player player);

    List<Item> getDrops();

    Direction getDirection();

}
