package Program.VI_9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StrokeAndFill extends JApplet implements ItemListener {
    JLabel primLabel, lineLabel, paintLabel, strokeLabel;
    ShapePanel display;
    static JComboBox<String> primitive, line, paint, stroke;
    public static boolean no2D = false;

    public void init() {
        GridBagLayout layout = new GridBagLayout();
        getContentPane().setLayout(layout);
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1.0;
        c.fill = GridBagConstraints.BOTH;

        // Primitive Label
        primLabel = new JLabel("Primitive");
        Font newFont = getFont().deriveFont(Font.BOLD);
        primLabel.setFont(newFont);
        primLabel.setHorizontalAlignment(JLabel.CENTER);
        layout.setConstraints(primLabel, c);
        getContentPane().add(primLabel);

        // Line Label
        lineLabel = new JLabel("Lines");
        lineLabel.setFont(newFont);
        lineLabel.setHorizontalAlignment(JLabel.CENTER);
        layout.setConstraints(lineLabel, c);
        getContentPane().add(lineLabel);

        // Paint Label
        c.gridwidth = GridBagConstraints.RELATIVE;
        paintLabel = new JLabel("Paints");
        paintLabel.setFont(newFont);
        paintLabel.setHorizontalAlignment(JLabel.CENTER);
        layout.setConstraints(paintLabel, c);
        getContentPane().add(paintLabel);

        // Stroke Label
        c.gridwidth = GridBagConstraints.REMAINDER;
        strokeLabel = new JLabel("Rendering");
        strokeLabel.setFont(newFont);
        strokeLabel.setHorizontalAlignment(JLabel.CENTER);
        layout.setConstraints(strokeLabel, c);
        getContentPane().add(strokeLabel);

        // ComboBoxes
        GridBagConstraints ls = new GridBagConstraints();
        ls.weightx = 1.0;
        ls.fill = GridBagConstraints.BOTH;

        primitive = new JComboBox<>(new String[]{"rectangle", "ellipse", "text"});
        primitive.addItemListener(this);
        primitive.setFont(newFont.deriveFont(14.0f));
        layout.setConstraints(primitive, ls);
        getContentPane().add(primitive);

        line = new JComboBox<>(new String[]{"thin", "thick", "dashed"});
        line.addItemListener(this);
        line.setFont(newFont.deriveFont(14.0f));
        layout.setConstraints(line, ls);
        getContentPane().add(line);

        ls.gridwidth = GridBagConstraints.RELATIVE;
        paint = new JComboBox<>(new String[]{"solid", "gradient", "polka"});
        paint.addItemListener(this);
        paint.setFont(newFont.deriveFont(14.0f));
        layout.setConstraints(paint, ls);
        getContentPane().add(paint);

        ls.gridwidth = GridBagConstraints.REMAINDER;
        stroke = new JComboBox<>(new String[]{"stroke", "fill", "stroke & fill"});
        stroke.addItemListener(this);
        stroke.setFont(newFont.deriveFont(14.0f));
        layout.setConstraints(stroke, ls);
        getContentPane().add(stroke);

        // Display Panel
        GridBagConstraints sc = new GridBagConstraints();
        sc.fill = GridBagConstraints.BOTH;
        sc.weightx = 1.0;
        sc.weighty = 1.0;
        sc.gridwidth = GridBagConstraints.REMAINDER;

        display = new ShapePanel();
        layout.setConstraints(display, sc);
        display.setBackground(Color.white);
        getContentPane().add(display);

        validate();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        display.renderShape();
    }

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("-no2d")) {
            StrokeAndFill.no2D = true;
        }

        JFrame frame = new JFrame("StrokeAndFill");
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        JApplet applet = new StrokeAndFill();
        frame.getContentPane().add(BorderLayout.CENTER, applet);
        applet.init();
        frame.setSize(450, 250);
        frame.setVisible(true);
    }
}
