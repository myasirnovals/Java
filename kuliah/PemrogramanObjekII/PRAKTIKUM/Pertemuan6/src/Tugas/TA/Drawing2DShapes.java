package Tugas.TA;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class Drawing2DShapes extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int radius = 100;

        for (int i = 0; i < 360; i += 15) {
            g2.setColor(Color.getHSBColor((float) i / 360, 1.0f, 1.0f));

            AffineTransform transform = new AffineTransform();
            transform.translate(centerX, centerY);
            transform.rotate(Math.toRadians(i));
            transform.translate(-radius / 2, -radius / 2);

            Shape star = createStar(radius, radius / 2);
            Shape transformedStar = transform.createTransformedShape(star);

            g2.fill(transformedStar);
        }
    }

    private Shape createStar(int outerRadius, int innerRadius) {
        Path2D path = new Path2D.Double();
        double angleStep = Math.PI / 5;
        for (int i = 0; i < 10; i++) {
            double angle = i * angleStep;
            double radius = (i % 2 == 0) ? outerRadius : innerRadius;
            double x = Math.cos(angle) * radius;
            double y = Math.sin(angle) * radius;
            if (i == 0) {
                path.moveTo(x, y);
            } else {
                path.lineTo(x, y);
            }
        }
        path.closePath();
        return path;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Drawing 2D Shapes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.add(new Drawing2DShapes());
        frame.setVisible(true);
    }
}
