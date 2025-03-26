package Program.VI_2;

import Program.VI_1.ColorJPanel;

import javax.swing.*;

public class ShowColors {
    public static void main(String args[]) {
        JFrame frame = new JFrame("Using colors");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ColorJPanel colorJPanel = new ColorJPanel();

        frame.add(colorJPanel);
        frame.setSize(400, 180);
        frame.setVisible(true);
    }
}
