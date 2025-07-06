package mini.carlos.skyblock.engine.entity;

import lombok.Data;
import mini.carlos.skyblock.engine.commons.KeyboardHelper;
import mini.carlos.skyblock.engine.commons.TileSpriteImpl;
import mini.carlos.skyblock.shared.Drawable;
import mini.carlos.skyblock.shared.attribute.Attribute;
import mini.carlos.skyblock.shared.attribute.AttributeKey;
import mini.carlos.skyblock.shared.player.Player;
import mini.carlos.skyblock.shared.player.PlayerInventory;
import mini.carlos.skyblock.shared.tile.TileSprite;
import mini.carlos.skyblock.shared.world.Position;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Unmodifiable;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Data
public class PlayerEngine implements Player, KeyListener {

    private final UUID uuid;
    private final String name;

    private double health;
    private double maxHealth;

    private final Position position;
    private final TileSprite sprite;

    private final PlayerInventory inventory;
    private final List<Attribute> attributes;

    private final long flags;

    private boolean movement;
    private double velocity;

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
        this.velocity = 6;
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

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (KeyboardHelper.isUp(keyCode)) {
            System.out.println("UP");
            position.add(0, velocity, 0);
        }

        if (KeyboardHelper.isDown(keyCode)) {
            System.out.println("DOWN");
            position.add(0, -velocity, 0);
        }

        if (KeyboardHelper.isLeft(keyCode)) {
            System.out.println("LEFT");
            position.add(-velocity, 0, velocity);
        }

        if (KeyboardHelper.isRight(keyCode)) {
            System.out.println("RIGHT");
            position.add(velocity, 0, -velocity);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public void draw(Graphics2D g, int panelWidth, int panelHeight) {
        Drawable.drawPanelSize(this, g, panelWidth, panelHeight);
    }


}
