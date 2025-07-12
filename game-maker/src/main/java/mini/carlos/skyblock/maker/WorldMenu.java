package mini.carlos.skyblock.maker;

import mini.carlos.skyblock.maker.commons.RoundedPanel;
import mini.carlos.skyblock.maker.world.WorldData;
import mini.carlos.skyblock.maker.world.WorldGridPanel;
import mini.carlos.skyblock.shared.block.BlockKey;
import mini.carlos.skyblock.shared.block.BlockResource;
import mini.carlos.skyblock.shared.manager.ResourceRegistry;
import mini.carlos.skyblock.shared.tile.Tile;

import javax.swing.*;
import java.awt.*;

public class WorldMenu {

    private final int worldSize;
    private final String worldName;

    public WorldMenu(int worldSize, String worldName) {
        this.worldSize = worldSize;
        this.worldName = worldName;
    }

    public void createPanel(JFrame mainFrame) {
        mainFrame.getContentPane().removeAll();
        mainFrame.setContentPane(new JPanel(new BorderLayout()));

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel sideBarLeftPanel = new JPanel();
        sideBarLeftPanel.setBackground(Color.MAGENTA);
        sideBarLeftPanel.setPreferredSize(new Dimension(200, 0));
        mainPanel.add(sideBarLeftPanel, BorderLayout.WEST);
        createSidebar(sideBarLeftPanel);

        BlockResource blockResource = ResourceRegistry.get(BlockResource.class);
        Tile outlineBlock = blockResource.getTile(BlockKey.GRASS);
        WorldData worldData = new WorldData(worldSize);
        WorldGridPanel editorGridPanel = new WorldGridPanel(worldData, outlineBlock, blockResource);

        mainPanel.add(editorGridPanel, BorderLayout.CENTER);

        mainFrame.setContentPane(mainPanel);
        mainFrame.revalidate();
        mainFrame.repaint();
    }


    private void createSidebar(JPanel basePanel) {
        JPanel sideBarPanel = new JPanel(new BorderLayout());
        JPanel leftPadding = new JPanel();
        leftPadding.setSize(10, 0);
        sideBarPanel.add(leftPadding, BorderLayout.WEST);

        JPanel rightPadding = new JPanel();
        rightPadding.setSize(10, 0);
        sideBarPanel.add(rightPadding, BorderLayout.EAST);

        JPanel centerPanel = new RoundedPanel(20, Color.BLACK);
        centerPanel.setVisible(true);

        int centerWidth = (int) basePanel.getPreferredSize().getWidth() - (leftPadding.getWidth() + rightPadding.getWidth());
        centerPanel.setPreferredSize(new Dimension(centerWidth, 100));
        System.out.println(centerPanel.getWidth());

        sideBarPanel.add(centerPanel, BorderLayout.CENTER);
        sideBarPanel.setVisible(true);

        basePanel.add(sideBarPanel);
    }


    private void createWorldDiagram(){

    }

    public static void createWorldDialog(JFrame mainFrame) {
        JDialog dialog = new JDialog();
        dialog.setLayout(new GridBagLayout());
        dialog.setTitle("Create World");
        dialog.setSize(300, 250);
        dialog.setLocationRelativeTo(null);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.gridx = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;

        // Label: World Name
        constraints.gridy = 0;
        dialog.add(new JLabel("World Name:"), constraints);

        // Input: World Name
        constraints.gridy = 1;
        JTextField worldNameField = new JTextField();
        dialog.add(worldNameField, constraints);

        // Label: World Size
        constraints.gridy = 2;
        dialog.add(new JLabel("World Size:"), constraints);

        // Input: World Size
        constraints.gridy = 3;
        JSpinner worldSizeSpinner = new JSpinner(new SpinnerNumberModel(2, 1, 512, 1));
        dialog.add(worldSizeSpinner, constraints);

        // Button: Create
        constraints.gridy = 4;
        JButton createWorldButton = new JButton("Create World");
        dialog.add(createWorldButton, constraints);

        createWorldButton.addActionListener(e -> {
            String worldName = worldNameField.getText().trim();
            int worldSize = (int) worldSizeSpinner.getValue();

            if (worldName.isEmpty()) {
                JOptionPane.showMessageDialog(dialog, "World name is required.");
                return;
            }

            System.out.println("Creating world: " + worldName + " (size: " + worldSize + ")");
            var newMenu = new WorldMenu(worldSize, worldName);
            newMenu.createPanel(mainFrame);

            dialog.dispose();
        });

        dialog.setVisible(true);
    }

}
