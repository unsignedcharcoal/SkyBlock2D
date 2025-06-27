package mini.carlos.skyblock.shared;

import mini.carlos.skyblock.shared.tile.Tile;
import mini.carlos.skyblock.shared.tile.TileSprite;
import mini.carlos.skyblock.shared.world.Position;

import java.awt.*;

public interface Drawable {

    int TILE_WIDTH = 24;
    int TILE_HEIGHT = 24;

    static void drawOffset(Tile tile, Graphics2D g, int offsetX, int offsetY){
        Position position = tile.getPosition();
        TileSprite sprite =  tile.getSprite();

        int x = position.getWorldX();
        int y = position.getWorldY();
        int z = position.getWorldZ();

        int screenX = calcScreenX(x, z, offsetX);
        int screenY = calcScreenY(x, y, z, offsetY);

        g.drawImage(sprite.image(),  screenX, screenY, null);
    }

    static void drawPanelSize(Tile tile, Graphics2D g, int panelWidth, int panelHeight) {
        Position position = tile.getPosition();
        TileSprite sprite = tile.getSprite();

        if (sprite == null || sprite.image() == null) return;

        int x = position.getWorldX();
        int y = position.getWorldY();
        int z = position.getWorldZ();

        // Define o centro do painel como base
        int offsetX = panelWidth / 2;
        int offsetY = panelHeight / 2;

        // Cálculo da posição isométrica
        int screenX = calcScreenX(x, z, offsetX);
        int screenY = calcScreenY(x, y, z, offsetY);

        g.drawImage(sprite.image(), screenX, screenY, null);
    }

    static int calcScreenX(int x, int z, int offsetX){
        return (x - z) * (TILE_WIDTH / 2) + offsetX;
    }

    static int calcScreenY(int x, int y, int z, int offsetY){
        return (x + z) * (TILE_HEIGHT / 4) - (y * TILE_HEIGHT / 2) + offsetY;
    }

}
