package mini.carlos.skyblock.engine.commons;

import mini.carlos.skyblock.shared.tile.TileSprite;
import org.jetbrains.annotations.NotNull;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public record TileSpriteImpl(BufferedImage image) implements TileSprite {

    private static final Map<String, TileSpriteImpl> cache = new HashMap<>();

    public static @NotNull TileSpriteImpl fromPNG(String pngName) {
        return cache.computeIfAbsent(pngName, name -> {
            try {
                var resource = TileSpriteImpl.class.getResourceAsStream("/tiles/" + name);
                if (resource == null) throw new RuntimeException("Image not found: " + name);

                var original = ImageIO.read(resource);

                BufferedImage compatible = new BufferedImage(
                        original.getWidth(), original.getHeight(),
                        BufferedImage.TYPE_INT_ARGB
                );

                var g2d = compatible.createGraphics();
                g2d.drawImage(original, 0, 0, null);
                g2d.dispose();

                return new TileSpriteImpl(compatible);
            } catch (IOException e) {
                throw new RuntimeException("Error loading image: " + name, e);
            }
        });
    }


}
