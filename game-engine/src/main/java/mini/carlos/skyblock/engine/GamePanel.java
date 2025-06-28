package mini.carlos.skyblock.engine;

import mini.carlos.skyblock.engine.entity.MoveableEntity;
import mini.carlos.skyblock.engine.entity.PlayerEngine;
import mini.carlos.skyblock.shared.Drawable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.AffineTransform;

public class GamePanel extends JPanel implements MouseWheelListener {

    private double scale = 1.0;

    private final PlayerEngine player;

    public GamePanel(PlayerEngine player) {
        this.player = player;

        setDoubleBuffered(true);
        addMouseWheelListener(this);

        setFocusable(true);
        requestFocusInWindow();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // 24 / 4 = 6
                int speed = 6;
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_W ->{
                        MoveableEntity.moveEntity(player, GamePanel.this, 0, speed, 0);
                    }
                    case KeyEvent.VK_S -> {
                        MoveableEntity.moveEntity(player, GamePanel.this, 0, -speed, 0);
                    }
                    case KeyEvent.VK_A -> {
                        MoveableEntity.moveEntity(player, GamePanel.this, -speed, 0, speed);
                    }
                    case KeyEvent.VK_D -> {
                        MoveableEntity.moveEntity(player, GamePanel.this, speed, 0, -speed);
                    }
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;


        AffineTransform original = graphics2D.getTransform();

        graphics2D.translate(centerX, centerY);
        graphics2D.scale(scale, scale);
        graphics2D.translate(-centerX - centerX, -centerY - centerY);

        Drawable.drawOffset(player, graphics2D, 0, 0);

        graphics2D.setTransform(original);
    }


    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        int notches = e.getWheelRotation();
        if (notches < 0) {
            scale *= 1.1;
        } else {
            scale /= 1.1;
        }

        // Limit of zoom
        scale = Math.max(0.25, Math.min(3.0, scale));
        repaint();
    }
}
