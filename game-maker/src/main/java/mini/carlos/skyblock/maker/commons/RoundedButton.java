package mini.carlos.skyblock.maker.commons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RoundedButton extends JButton {

    private final int radius;
    private final Color backgroundColor;
    private final Color borderColor;
    private final Color hoverColor;
    private final Color pressedColor;

    private boolean hovered = false;
    private boolean pressed = false;

    public RoundedButton(String text, int radius, Color backgroundColor, Color borderColor) {
        super(text);
        this.radius = radius;
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
        this.hoverColor = backgroundColor.brighter();
        this.pressedColor = backgroundColor.darker();

        setOpaque(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setForeground(Color.decode("#2b2b2b"));
        setFont(getFont().deriveFont(Font.BOLD));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                hovered = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hovered = false;
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                pressed = true;
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                pressed = false;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Color fillColor = backgroundColor;
        Cursor cursor = Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR);

        if (pressed) {
            fillColor = pressedColor;
        } else if (hovered) {
            fillColor = hoverColor;
            cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
        }

        setCursor(cursor);
        g2.setColor(fillColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

        super.paintComponent(g);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(borderColor);
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
        g2.dispose();
    }
}
