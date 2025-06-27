package mini.carlos.skyblock.engine;

import mini.carlos.skyblock.shared.tile.TileSprite;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public record TileSpriteImpl(Image image) implements TileSprite {

    public static TileSpriteImpl fromPNG(String pngName) {
        try {
            var img = ImageIO.read(Objects.requireNonNull(TileSpriteImpl.class.getResourceAsStream("/tiles/" + pngName)));
            return new TileSpriteImpl(img);
        } catch (IOException e) {
            throw new RuntimeException("Error while loading the image: " + pngName, e);

        }
    }
}
