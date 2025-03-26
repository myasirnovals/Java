package Program.VI_6;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class Graphics2DExample extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        int x = 50;
        int y = 50;
        int rectWidth = 100;
        int rectHeight = 50;

        BasicStroke stroke = new BasicStroke(2.0f);
        BasicStroke wideStroke = new BasicStroke(3.0f);
        BasicStroke dashed = new BasicStroke(1.0f,
                BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER,
                10.0f,
                new float[]{10.0f},
                0.0f);

        g2.setStroke(stroke);
        g2.draw(new Line2D.Double(x, y + rectHeight - 1, x + rectWidth, y));

        y += 80;
        g2.setStroke(stroke);
        g2.draw(new Rectangle2D.Double(x, y, rectWidth, rectHeight));

        y += 80;
        g2.setStroke(dashed);
        g2.draw(new RoundRectangle2D.Double(x, y, rectWidth, rectHeight, 10, 10));

        y += 80;
        g2.setStroke(wideStroke);
        g2.draw(new Arc2D.Double(x, y, rectWidth, rectHeight, 90, 135, Arc2D.OPEN));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Berbagai Bentuk 2D");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Graphics2DExample());
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

