package mini.carlos.skyblock.maker.world;

import mini.carlos.skyblock.shared.Drawable;
import mini.carlos.skyblock.shared.block.BlockKey;
import mini.carlos.skyblock.shared.block.BlockResource;
import mini.carlos.skyblock.shared.tile.Tile;
import mini.carlos.skyblock.shared.world.Position3D;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;

public class WorldGridPanel extends JPanel implements MouseMotionListener, MouseListener {

    private Position3D hoverBlockPos = null;

    private final Tile baseBlock;
    private final WorldData worldData;
    private final BlockResource blockResource;

    private final Tile OUTILINE_WHITE;

    public WorldGridPanel(WorldData worldData, Tile baseBlock, BlockResource blockResource) {
        this.worldData = worldData;
        this.baseBlock = baseBlock;
        this.blockResource = blockResource;
        this.OUTILINE_WHITE = blockResource.getTile(BlockKey.WHITE_OUTLINE);

        worldData.generateGrid(baseBlock);

        worldData.getTiles().forEach((pos, tile) -> {
            System.out.println(pos.string() + " " + tile.getKey());
        });

        setDoubleBuffered(true);

        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        worldData.fetchTiles((pos, tile) -> {
            Drawable.drawPanelSize(tile.getSprite(), pos.x(), pos.y(), pos.z(), g2d, getWidth(), getHeight());
        });

        if (hoverBlockPos != null) {
            Drawable.drawPanelSize(OUTILINE_WHITE.getSprite(), hoverBlockPos.x(), hoverBlockPos.y(), hoverBlockPos.z(), g2d, getWidth(), getHeight());
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        hoverBlockPos = getHoveredBlockFromMouse(e.getX(), e.getY());
        repaint();
    }

    private Position3D getHoveredBlockFromMouse(int mouseX, int mouseY) {
        int offsetX = getWidth() / 2;
        int offsetY = getHeight() / 2;

        int tileSize = Drawable.TILE_SIZE;
        int maxY = worldData.getSize();

        for (int y = maxY - 1; y >= 0; y--) {
            int sx = mouseX - offsetX;
            int sy = mouseY - offsetY + (y * tileSize / 2);

            double dx = sx / (tileSize / 2.0);
            double dz = sy / (tileSize / 4.0);

            int x = (int) Math.floor((dx + dz) / 2.0);
            int z = (int) Math.floor((dz - dx) / 2.0);

            Tile tile = worldData.getTile(x, y, z);
            if (tile != null && isMouseInsideBlock(mouseX, mouseY, x, y, z)) {
                return new Position3D(x, y, z);
            }
        }

        return null;
    }

    private boolean isMouseInsideBlock(int mouseX, int mouseY, int x, int y, int z) {
        int offsetX = getWidth() / 2;
        int offsetY = getHeight() / 2;

        int screenX = Drawable.calcScreenX(x, z, offsetX);
        int screenY = Drawable.calcScreenY(x, y, z, offsetY);

        int halfW = Drawable.TILE_SIZE / 2;
        int halfH = Drawable.TILE_SIZE / 4;

        Polygon diamond = new Polygon();
        diamond.addPoint(screenX, screenY); // TOP
        diamond.addPoint(screenX + halfW, screenY + halfH); // RIGHT
        diamond.addPoint(screenX, screenY + halfH * 2); // BOTTOM
        diamond.addPoint(screenX - halfW, screenY + halfH); // LEFT

        return diamond.contains(mouseX, mouseY);
    }



    public void mouseClicked(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseDragged(MouseEvent e) {}
}
