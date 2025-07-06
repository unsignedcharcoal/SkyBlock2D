package mini.carlos.skyblock.maker;

import mini.carlos.skyblock.maker.commons.MakerButton;
import mini.carlos.skyblock.maker.commons.RoundedButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;

public class MakerPanel extends JPanel {

    public MakerPanel() {
        setFocusable(true);
    }

    public void createButton(){
        JButton button = MakerButton.create("Create Empty World");
        button.addMouseListener(new MouseAdapter() {
        });
        add(button);
    }
}
