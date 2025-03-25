package Tugas.IV_5;

import javax.swing.*;
import java.awt.*;

public class TicTacToeGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Tic-Tac-Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 350);
        frame.setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);

        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(3, 3, 5, 5));
        for (int i = 0; i < 9; i++) {
            JButton button = new JButton();
            gridPanel.add(button);
        }

        frame.add(gridPanel, BorderLayout.CENTER);

        JLabel statusLabel = new JLabel("Player Ones' Turn", SwingConstants.CENTER);
        frame.add(statusLabel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
