package mini.carlos.skyblock.shared.player;

import mini.carlos.skyblock.shared.entity.Entity;

import java.util.UUID;

public interface Player extends Entity {

    UUID getUuid();

    String getName();

    PlayerInventory getInventory();

}
