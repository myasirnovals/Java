package Tugas.TA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGUI {
    private static String currentPlayer = "X";
    private static JButton[] buttons = new JButton[9];
    private static JLabel statusLabel = new JLabel("Player X's Turn", SwingConstants.CENTER);

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
            button.setFont(new Font("Arial", Font.BOLD, 40));
            buttons[i] = button;
            gridPanel.add(button);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (button.getText().isEmpty()) {
                        button.setText(currentPlayer);
                        if (checkWin()) {
                            statusLabel.setText("Player " + currentPlayer + " Wins!");
                            disableButtons();
                        } else if (isDraw()) {
                            statusLabel.setText("It's a Draw!");
                        } else {
                            currentPlayer = currentPlayer.equals("X") ? "O" : "X";
                            statusLabel.setText("Player " + currentPlayer + "'s Turn");
                        }
                    }
                }
            });
        }

        frame.add(gridPanel, BorderLayout.CENTER);

        frame.add(statusLabel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private static boolean checkWin() {
        int[][] winConditions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

        for (int[] condition : winConditions) {
            if (buttons[condition[0]].getText().equals(currentPlayer) && buttons[condition[1]].getText().equals(currentPlayer) && buttons[condition[2]].getText().equals(currentPlayer)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDraw() {
        for (JButton button : buttons) {
            if (button.getText().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private static void disableButtons() {
        for (JButton button : buttons) {
            button.setEnabled(false);
        }
    }
}