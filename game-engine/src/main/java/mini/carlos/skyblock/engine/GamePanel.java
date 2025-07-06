package mini.carlos.skyblock.engine;

import mini.carlos.skyblock.engine.entity.PlayerEngine;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class GamePanel extends Canvas implements Runnable {

    private Thread gameThread;
    private boolean running = false;

    private final PlayerEngine player;

    public GamePanel(PlayerEngine player) {
        this.player = player;
        setPreferredSize(new Dimension(800, 600));
        setFocusable(true);

        addKeyListener(player);
    }

    public void startGame() {
        if (running) return;

        running = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void stopGame() {
        running = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void run() {
        final int FPS = 60;
        final double drawInterval = 1_000_000_000.0 / FPS;

        double delta = 0;
        long lastTime = System.nanoTime();
        long timer = 0;
        int frames = 0;

        createBufferStrategy(3); // triple buffering
        BufferStrategy bs = getBufferStrategy();

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / drawInterval;
            timer += (now - lastTime);
            lastTime = now;

            // Game logic
            while (delta >= 1) {
                update();
                delta--;
            }

            // Render
            Graphics2D g = (Graphics2D) bs.getDrawGraphics();
            draw(g);
            g.dispose();
            bs.show();
            Toolkit.getDefaultToolkit().sync(); // tearing Linux

            frames++;

            // Show FPS
            if (timer >= 1_000_000_000) {
                //System.out.println("FPS: " + frames);
                frames = 0;
                timer = 0;
            }

            try {
                Thread.sleep(1); // CPU control
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public void update() {
    }

    public void draw(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight()); // limpa a tela

        player.draw(g, getWidth(), getHeight());
    }
}
