package mini.carlos.skyblock.maker.gfx;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Resource {

    private static final Map<String, BufferedImage> tileCache = new HashMap<>();
    private static final Map<String, BufferedImage> imageCache = new HashMap<>();

    private static BufferedImage tileSheet;
    private static final int TILE_SIZE = 16;

    static {
        loadTileSheet("/tiles/tiles.png");

        registerTile("grass", 0, 0);
        registerTile("stone", 1, 0);
        registerTile("wood", 2, 0);
        registerTile("water", 3, 0);
    }

    private static void loadTileSheet(String path) {
        try {
            tileSheet = ImageIO.read(Objects.requireNonNull(Resource.class.getResourceAsStream(path)));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao carregar spritesheet: " + path, e);
        }
    }

    private static void registerTile(String name, int col, int row) {
        BufferedImage tile = tileSheet.getSubimage(
                col * TILE_SIZE,
                row * TILE_SIZE,
                TILE_SIZE,
                TILE_SIZE
        );
        tileCache.put(name, tile);
    }

    public static BufferedImage getTile(String name) {
        return tileCache.get(name);
    }

    public static BufferedImage getImage(String path) {
        return imageCache.computeIfAbsent(path, p -> {
            try {
                return ImageIO.read(Objects.requireNonNull(Resource.class.getResourceAsStream(p)));
            } catch (Exception e) {
                throw new RuntimeException("Erro ao carregar imagem: " + p, e);
            }
        });
    }
}
