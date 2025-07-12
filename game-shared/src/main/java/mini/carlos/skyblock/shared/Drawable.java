package mini.carlos.skyblock.shared;

import mini.carlos.skyblock.shared.entity.Entity;
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
        drawPanelSize(sprite, (int) position.getX(), (int) position.getY(), (int)  position.getZ(), g, panelWidth, panelHeight);
    }

    static void drawPanelSize(TileSprite sprite, int x, int y, int z, Graphics2D g, int panelWidth, int panelHeight) {
        if (sprite == null || sprite.image() == null) return;

        int offsetX = panelWidth / 2;
        int offsetY = panelHeight / 2;

        int screenX = calcScreenX(x, z, offsetX);
        int screenY = calcScreenY(x, y, z, offsetY);

        g.drawImage(sprite.image(), screenX, screenY, null);
    }

    static void drawPanelSize(Entity entity, Graphics2D g, int panelWidth, int panelHeight){
        drawPanelSize(entity.getSprite(), entity.getPosition(), g, panelWidth, panelHeight);
    }

    static int calcScreenX(int x, int z, int offsetX){
        return calcScreenX(x, z) + offsetX;
    }

    static int calcScreenY(int x, int y, int z, int offsetY){
        return calcScreenY(x, y, z) + offsetY;
    }

    static int calcScreenX(int x, int z) {
        return (x - z) * TILE_SIZE / 2;
    }

    static int calcScreenY(int x, int y, int z) {
        return (x + z) * TILE_SIZE / 4 - y * TILE_SIZE / 2;
    }


}
