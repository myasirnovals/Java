package ui;

import util.PlayerSelection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ShipSelectionPanel extends JPanel implements ActionListener {
    private JButton[] shipButtons;
    private JButton confirmButtons;
    private GameWindow gameWindow;
    private int selectedShip = 0;

    private String[] shipImages = {
            "assets/Character.Ships/ship_0000.png",
            "assets/Character.Ships/ship_0001.png",
            "assets/Character.Ships/ship_0002.png",
            "assets/Character.Ships/ship_0003.png"
    };

    public ShipSelectionPanel(GameWindow gW) {
        this.gameWindow = gW;
        setLayout(new BorderLayout());

        JPanel shipsPanel = new JPanel();
        shipsPanel.setLayout(new FlowLayout());

        shipButtons = new JButton[shipImages.length];
        ButtonGroup group = new ButtonGroup();

        for (int i = 0; i < shipImages.length; i++) {
            ImageIcon icon = new ImageIcon(shipImages[i]);
            shipButtons[i] = new JButton(icon);
            shipButtons[i].setActionCommand(String.valueOf(i));
            shipButtons[i].addActionListener(this);
            shipsPanel.add(shipButtons[i]);
            group.add(shipButtons[i]);
        }
        shipButtons[0].setSelected(true);

        confirmButtons = new JButton("Pilih Pesawat");
        confirmButtons.addActionListener(e -> {
            PlayerSelection.setSelectedShipIndex(selectedShip);
            gameWindow.showGame();
        });

        add(new JLabel("Pilih Pesawat Anda", JLabel.CENTER), BorderLayout.NORTH);
        add(shipsPanel, BorderLayout.CENTER);
        add(confirmButtons, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e) {
        selectedShip = Integer.parseInt(e.getActionCommand());
    }
}
