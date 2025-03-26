package Program.VI_5;

import javax.swing.*;
import java.awt.*;

public class GraphicsExample extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);

        int[] xPoints = {50, 150, 200, 150, 50};
        int[] yPoints = {50, 50, 100, 150, 150};
        int nPoints = 5;

        g.fillPolygon(xPoints, yPoints, nPoints);

        g.setColor(Color.RED);
        g.fillRect(250, 50, 150, 100);

        g.setColor(Color.GREEN);
        g.fillOval(50, 200, 100, 80);

        g.setColor(Color.ORANGE);
        g.fillArc(250, 200, 100, 100, 45, 270);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Program 6-5: Shapes Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new GraphicsExample());
        frame.setSize(450, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
