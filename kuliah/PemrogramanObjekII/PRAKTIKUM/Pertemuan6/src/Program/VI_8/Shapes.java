package Program.VI_8;

import Program.VI_7.ShapesJPanel;

import javax.swing.*;

public class Shapes {
    public static void main(String args[]) {
        JFrame frame = new JFrame("Drawing 2D shapes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ShapesJPanel shapesJPanel = new ShapesJPanel();
        frame.add(shapesJPanel);
        frame.setSize(425, 200);
        frame.setVisible(true);
    }
}
