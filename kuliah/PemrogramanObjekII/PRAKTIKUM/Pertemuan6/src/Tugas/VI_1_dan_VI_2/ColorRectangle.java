package Tugas.VI_1_dan_VI_2;

import javax.swing.*;
import java.awt.*;

public class ColorRectangle {
    static class RectanglePanel extends JPanel {
        private Color rectangleColor = Color.WHITE;

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(rectangleColor);
            g.fillRect(100, 50, 200, 100);
        }

        public void setRectangleColor(Color color) {
            this.rectangleColor = color;
            repaint();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Color Rectangle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        RectanglePanel rectanglePanel = new RectanglePanel();

        JButton redButton = new JButton("Red");
        JButton blueButton = new JButton("Blue");
        JButton greenButton = new JButton("Green");

        redButton.addActionListener(e -> rectanglePanel.setRectangleColor(Color.RED));
        blueButton.addActionListener(e -> rectanglePanel.setRectangleColor(Color.BLUE));
        greenButton.addActionListener(e -> rectanglePanel.setRectangleColor(Color.GREEN));

        buttonPanel.add(redButton);
        buttonPanel.add(blueButton);
        buttonPanel.add(greenButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.add(rectanglePanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}