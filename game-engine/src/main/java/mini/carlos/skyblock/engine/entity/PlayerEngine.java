package mini.carlos.skyblock.engine.entity;

import lombok.Data;
import mini.carlos.skyblock.engine.commons.TileSpriteImpl;
import mini.carlos.skyblock.shared.attribute.Attribute;
import mini.carlos.skyblock.shared.attribute.AttributeKey;
import mini.carlos.skyblock.shared.player.Player;
import mini.carlos.skyblock.shared.player.PlayerInventory;
import mini.carlos.skyblock.shared.tile.TileSprite;
import mini.carlos.skyblock.shared.world.Position;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Unmodifiable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Data
public class PlayerEngine implements Player {

    private final UUID uuid;
    private final String name;

    private double health;
    private double maxHealth;

    private final Position position;
    private final TileSprite sprite;

    private final PlayerInventory inventory;
    private final List<Attribute> attributes;

    private final long flags;

    public PlayerEngine(UUID uuid, String name){
        this.uuid = uuid;
        this.name = name;
        this.health = 100;
        this.maxHealth = 100;
        this.position = new Position();
        this.sprite = TileSpriteImpl.fromPNG("test_player.png");
        this.inventory = new PlayerInventory(PlayerInventory.START_INVENTORY_SIZE);
        this.attributes = new ArrayList<>();
        this.flags = 0;
    }

    @Override
    public void setHealth(double health) {
        this.health = health;
    }

    @Override
    public void setMaxHealth(double maxHealth) {
        this.maxHealth = maxHealth;
    }

    @Override
    public @Unmodifiable List<Attribute> getAttributes() {
        return attributes;
    }

    @Override
    public @Nullable Attribute getAttribute(AttributeKey key) {
        return attributes.stream()
                .filter(attribute -> attribute.getKey().equals(key.getKey()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Optional<Attribute> getAttributeOptional(AttributeKey key) {
        return Optional.ofNullable(getAttribute(key));
    }

    @Override
    public long getFlags() {
        return flags;
    }
}
