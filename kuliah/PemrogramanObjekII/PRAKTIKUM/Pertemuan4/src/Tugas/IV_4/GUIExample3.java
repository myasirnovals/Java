package Tugas.IV_4;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;

public class GUIExample3 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("GUI example 3");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton fileButton = new JButton("File");
        JButton helpButton = new JButton("Help");

        topPanel.add(fileButton);
        topPanel.add(helpButton);

        frame.add(topPanel, BorderLayout.NORTH);

        JButton westButton = new JButton("West");
        westButton.setBorder(new LineBorder(Color.BLACK));
        frame.add(westButton, BorderLayout.WEST);

        JLabel workspaceLabel = new JLabel("Work space region", SwingConstants.CENTER);
        workspaceLabel.setBorder(new LineBorder(Color.BLACK));
        frame.add(workspaceLabel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}