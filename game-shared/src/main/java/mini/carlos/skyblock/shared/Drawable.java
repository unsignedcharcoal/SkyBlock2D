package mini.carlos.skyblock.shared;

import mini.carlos.skyblock.shared.entity.Entity;
import mini.carlos.skyblock.shared.tile.Tile;
import mini.carlos.skyblock.shared.tile.TileSprite;
import mini.carlos.skyblock.shared.world.Position;

import java.awt.*;

public interface Drawable {

    int TILE_SIZE = 24;
    int TILE_GRID = 25;
    int TILE_PADDING = 1;

    static void drawOffset(TileSprite sprite, Position position, Graphics2D g, int offsetX, int offsetY){

        int x = (int) position.getX();
        int y = (int) position.getY();
        int z = (int) position.getZ();

        int screenX = calcScreenX(x, z, offsetX);
        int screenY = calcScreenY(x, y, z, offsetY);

        g.drawImage(sprite.image(),  screenX, screenY, null);
    }

    static void drawPanel(TileSprite sprite, Position position, Canvas panel){
        Graphics2D g2d = (Graphics2D) panel.getGraphics();
        int width = panel.getWidth();
        int height = panel.getHeight();
        drawPanelSize(sprite, position, g2d, width, height);
    }

    static void drawPanelSize(TileSprite sprite, Position position, Graphics2D g, int panelWidth, int panelHeight) {

        if (sprite == null || sprite.image() == null) return;

        int x = (int) position.getX();
        int y = (int) position.getY();
        int z = (int) position.getZ();

        // Define o centro do painel como base
        int offsetX = panelWidth / 2;
        int offsetY = panelHeight / 2;

        // Cálculo da posição isométrica
        int screenX = calcScreenX(x, z, offsetX);
        int screenY = calcScreenY(x, y, z, offsetY);

        g.drawImage(sprite.image(), screenX, screenY, null);
    }

    static void drawPanelSize(Entity entity, Graphics2D g, int panelWidth, int panelHeight){
        drawPanelSize(entity.getSprite(), entity.getPosition(), g, panelWidth, panelHeight);
    }

    static int calcScreenX(int x, int z, int offsetX){
        return (x - z) * (TILE_SIZE / 2) + offsetX;
    }

    static int calcScreenY(int x, int y, int z, int offsetY){
        return (x + z) * (TILE_SIZE / 4) - (y * TILE_SIZE / 2) + offsetY;
    }

}
