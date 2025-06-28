package mini.carlos.skyblock.engine.entity;

import mini.carlos.skyblock.engine.GamePanel;
import mini.carlos.skyblock.shared.Drawable;
import mini.carlos.skyblock.shared.entity.Entity;
import mini.carlos.skyblock.shared.world.Position;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class MoveableEntity {

    public static void moveEntity(@NotNull Entity entity, GamePanel gamePanel, int x, int y, int z) {
        Image image = entity.getSprite().image();
        if (image == null) return;

        Position position = entity.getPosition();
        position.add(x, y, z);

        Drawable.drawPanel(entity, gamePanel);
        gamePanel.repaint();
    }

}
