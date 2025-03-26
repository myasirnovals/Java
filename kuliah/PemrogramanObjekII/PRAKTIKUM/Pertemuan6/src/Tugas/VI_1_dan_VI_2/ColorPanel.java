package Tugas.VI_1_dan_VI_2;

import javax.swing.*;
import java.awt.*;

public class ColorPanel {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Color Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLayout(new GridLayout(10, 1));

        Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.ORANGE,
                Color.PINK, Color.CYAN, Color.MAGENTA, Color.GRAY, Color.LIGHT_GRAY};
        String[] colorNames = {
                "Red", "Blue", "Green", "Yellow", "Orange",
                "Pink", "Cyan", "Magenta", "Gray", "Light Gray"
        };

        for (int i = 0; i < colors.length; i++) {
            JPanel panel = new JPanel();
            panel.setBackground(colors[i]);
            JLabel label = new JLabel(colorNames[i]);
            label.setForeground(Color.BLACK);
            panel.add(label);
            frame.add(panel);
        }

        frame.setVisible(true);
    }
}
