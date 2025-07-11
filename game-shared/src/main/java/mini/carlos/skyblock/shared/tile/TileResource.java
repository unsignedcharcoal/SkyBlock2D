package mini.carlos.skyblock.shared.tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class TileResource<Key extends TileResourceKey> {

    public static final String BLOCKS_URL = "/blocks/";

    private final Map<String, BufferedImage> imageMap = new HashMap<>();
    private final Map<Key, Tile> tiles = new HashMap<>();

    private final int tileWidth;
    private final int tileHeight;
    private final int gridSize;
    private final int offsetX;
    private final int offsetY;

    public TileResource(int tileWidth, int tileHeight, int gridSize, int offsetX, int offsetY) {
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
        this.gridSize = gridSize;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
    }

    public void registerSheet(String id, String resourcePath) {
        try (InputStream stream = getClass().getResourceAsStream(resourcePath)) {
            if (stream == null) throw new RuntimeException("Sheet not found: " + resourcePath);
            BufferedImage image = ImageIO.read(stream);

            imageMap.put(id, image);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load sheet: " + id, e);
        }
    }

    public void registerTile(String sheetId, Key key, int col, int row) {
        BufferedImage sheet = imageMap.get(sheetId);
        if (sheet == null) {
            System.err.println("No sheet registered with id: " + sheetId);
            return;
        }

        BufferedImage tile = sheet.getSubimage(
                col * gridSize + offsetX,
                row * gridSize + offsetY,
                tileWidth,
                tileHeight
        );

        if (tile == null) {
            System.err.println("Failed to register tile: " + key.getKey() + "|" + key.getId());
            return;
        }

        Tile fromClass = new Tile() {
            @Override
            public TileResourceKey getKey() {
                return key;
            }

            @Override
            public TileSprite getSprite() {
                return () -> tile;
            }
        };

        tiles.put(key, fromClass);
    }


    public Tile getTile(Key key) {
        return tiles.get(key);
    }

    public Tile getTile(String strKey) {
        var key = tiles.keySet().stream().filter(k -> k.getKey().equals(strKey)).findFirst().orElse(null);
        if (key == null) {
            System.err.println("Key " + strKey + " not found!");
            return null;
        }

        return tiles.get(key);
    }

    public Tile getTile(int id) {
        var key = tiles.keySet().stream().filter(k -> k.getId() == id).findFirst().orElse(null);
        if (key == null) {
            System.err.println("Key by ID: " + id + " not found!");
            return null;
        }

        return tiles.get(key);
    }

    public List<Tile> getTiles() {
        return tiles.values().stream().toList();
    }

    public abstract void registerTiles();
}
