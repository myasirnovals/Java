package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import ui.ShipSelectionPanel;

public class MainMenu extends JPanel implements ActionListener {

    private JButton playButton, instructionsButton, exitButton;
    private GameWindow gameWindow;

    public MainMenu(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setLayout(null);
        setBackground(Color.BLACK);

        JLabel title = new JLabel("SPACE INVADERS");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 36));
        title.setBounds(250, 50, 400, 50);
        add(title);

        playButton = new JButton("Play");
        playButton.setBounds(350, 150, 100, 40);
        playButton.addActionListener(this);

        instructionsButton = new JButton("Instructions");
        instructionsButton.setBounds(330, 210, 140, 40);
        instructionsButton.addActionListener(this);

        exitButton = new JButton("Exit");
        exitButton.setBounds(350, 270, 100, 40);
        exitButton.addActionListener(this);

        add(playButton);
        add(instructionsButton);
        add(exitButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playButton) {
            gameWindow.showGame();
        } else if (e.getSource() == instructionsButton) {
            JOptionPane.showMessageDialog(this,
                "Controls:\n" +
                    "- Arrow Keys: Move Player\n" +
                    "- Space: Shoot\n\n" +
                    "Objective:\n" +
                    "- Defeat enemies and bosses\n" +
                    "- Collect power-ups\n" +
                    "- Avoid enemy hits\n\n" +
                    "Good Luck!",
                "Instructions",
                JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }
}
