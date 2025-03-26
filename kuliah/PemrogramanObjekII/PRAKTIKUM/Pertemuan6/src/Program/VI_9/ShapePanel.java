package Program.VI_9;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.font.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;

class ShapePanel extends JPanel {
    BasicStroke bstroke = new BasicStroke(3.0f);

    int w, h;
    Shape shapes[] = new Shape[3];

    public ShapePanel() {
        setBackground(Color.white);
        shapes[0] = new Rectangle(0, 0, 100, 100);
        shapes[1] = new Ellipse2D.Double(0.0, 0.0, 100.0, 100.0);
        TextLayout textTl = new TextLayout("Text", new Font("Helvetica", Font.BOLD, 96), new FontRenderContext(null, false, false));
        AffineTransform textAt = new AffineTransform();
        textAt.translate(0, (float) textTl.getBounds().getHeight());
        shapes[2] = textTl.getOutline(textAt);
    }

    public void renderShape() {
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (!StrokeAndFill.no2D) {
            Graphics2D g2 = (Graphics2D) g;
            Dimension d = getSize();
            w = d.width;
            h = d.height;

            // Instructions
            String instruct = "Pick a primitive, line paint, and rendering method.";
            TextLayout thisTl = new TextLayout(instruct, new Font("Helvetica", Font.PLAIN, 10), g2.getFontRenderContext());
            Rectangle2D bounds = thisTl.getBounds();
            int width = (int) bounds.getWidth();
            thisTl.draw(g2, w / 2 - width / 2, 20);

            Stroke oldStroke = g2.getStroke();

            // Set Stroke
            switch (StrokeAndFill.line.getSelectedIndex()) {
                case 0 -> g2.setStroke(new BasicStroke(3.0f));
                case 1 -> g2.setStroke(new BasicStroke(8.0f));
                case 2 -> {
                    float dash[] = {10.0f};
                    g2.setStroke(new BasicStroke(3.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f));
                }
            }

            Paint oldPaint = g2.getPaint();

            // Set Paint
            switch (StrokeAndFill.paint.getSelectedIndex()) {
                case 0 -> g2.setPaint(Color.blue);
                case 1 -> g2.setPaint(new GradientPaint(0, 0, Color.lightGray, w - 250, h, Color.blue, false));
                case 2 -> {
                    BufferedImage bi = new BufferedImage(5, 5, BufferedImage.TYPE_INT_RGB);
                    Graphics2D big = bi.createGraphics();
                    big.setColor(Color.blue);
                    big.fillRect(0, 0, 5, 5);
                    big.setColor(Color.lightGray);
                    big.fillOval(0, 0, 5, 5);
                    Rectangle r = new Rectangle(0, 0, 5, 5);
                    g2.setPaint(new TexturePaint(bi, r));
                }
            }

            // Set Shape
            Shape shape = shapes[StrokeAndFill.primitive.getSelectedIndex()];
            Rectangle r = shape.getBounds();

            // Center Shape
            AffineTransform saveXForm = g2.getTransform();
            AffineTransform toCenterAt = new AffineTransform();
            toCenterAt.translate(w / 2 - (r.width / 2), h / 2 - (r.height / 2));
            g2.transform(toCenterAt);

            // Render Shape
            switch (StrokeAndFill.stroke.getSelectedIndex()) {
                case 0 -> g2.draw(shape);
                case 1 -> g2.fill(shape);
                case 2 -> {
                    g2.fill(shape);
                    g2.setColor(Color.darkGray);
                    g2.draw(shape);
                }
            }

            g2.setTransform(saveXForm);
            g2.setStroke(oldStroke);
            g2.setPaint(oldPaint);
        } else {
            g.drawRect(0, 0, 100, 100);
        }
    }
}
