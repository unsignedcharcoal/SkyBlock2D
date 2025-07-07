package mini.carlos.skyblock.maker.world;

import javax.swing.*;
import java.awt.*;

public class WorldMakerPanel extends JPanel {

    public WorldMakerPanel() {
    }

    public static class WorldCreateDialog extends JDialog {

        private final JTextField nameField = new JTextField();
        private final JSpinner spinnerX = new JSpinner(new SpinnerNumberModel(64, 1, 512, 1));
        private final JSpinner spinnerZ = new JSpinner(new SpinnerNumberModel(64, 1, 512, 1));

        public WorldCreateDialog(JFrame parentFrame) {
            super(parentFrame, "Create World", true); // true = modal

            setLayout(new GridBagLayout());
            setSize(300, 250);
            setResizable(false);
            setLocationRelativeTo(parentFrame); //Center of panel

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(5, 10, 5, 10);
            gbc.anchor = GridBagConstraints.WEST;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridx = 0;

            // Nome
            gbc.gridy = 0;
            add(new JLabel("World Name:"), gbc);
            gbc.gridy++;
            add(nameField, gbc);

            // Size of X
            gbc.gridy++;
            add(new JLabel("Size of X:"), gbc);
            gbc.gridy++;
            add(spinnerX, gbc);

            // Size of Z
            gbc.gridy++;
            add(new JLabel("Size of Z:"), gbc);
            gbc.gridy++;
            add(spinnerZ, gbc);

            // Create button
            JButton createButton = new JButton("Create");
            gbc.gridy++;
            gbc.anchor = GridBagConstraints.CENTER;
            add(createButton, gbc);

            createButton.addActionListener(e -> {
                String name = nameField.getText().trim();
                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Write a name to create the world.");
                    return;
                }

                int x = (int) spinnerX.getValue();
                int z = (int) spinnerZ.getValue();

                System.out.printf("Preparing world: %s (%dx%d)%n", name, x, z);

                dispose(); // exit
            });
        }
    }
}
