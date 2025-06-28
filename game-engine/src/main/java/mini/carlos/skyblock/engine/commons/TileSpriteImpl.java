package mini.carlos.skyblock.engine.commons;

import mini.carlos.skyblock.shared.tile.TileSprite;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public record TileSpriteImpl(Image image) implements TileSprite {

    @Contract("_ -> new")
    public static @NotNull TileSpriteImpl fromPNG(String pngName) {
        try {
            var img = ImageIO.read(Objects.requireNonNull(TileSpriteImpl.class.getResourceAsStream("/tiles/" + pngName)));
            return new TileSpriteImpl(img);
        } catch (IOException e) {
            throw new RuntimeException("Error while loading the image: " + pngName, e);

        }
    }
}
