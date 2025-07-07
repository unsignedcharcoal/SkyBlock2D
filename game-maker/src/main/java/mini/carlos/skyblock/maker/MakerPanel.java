package mini.carlos.skyblock.maker;

import mini.carlos.skyblock.maker.commons.MakerButton;
import mini.carlos.skyblock.maker.world.WorldMakerPanel;

import javax.swing.*;

public class MakerPanel extends JPanel {

    public MakerPanel() {
        setFocusable(true);
        createButton();
    }

    public void createButton() {
        JButton button = MakerButton.create("Create Empty World");

        button.addActionListener(e -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            WorldMakerPanel.WorldCreateDialog dialog = new WorldMakerPanel.WorldCreateDialog(frame);
            dialog.setVisible(true);
        });

        //Transition menu
        /*button.addActionListener(e -> {
            removeAll();           // remove button and other components
            add(new WorldMakerPanel()); // add the panel
            revalidate();          // recalc the layout
            repaint();             // repaint the panel
        });*/

        add(button);
    }
}
