package Tugas.V_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingApplication extends JFrame implements ActionListener {
    private int numClicks = 0;
    private JLabel label;
    private JButton button;
    private static final String labelPrefix = "Number of clicks: ";

    public SwingApplication() {
        setTitle("Swing Application Example");

        label = new JLabel(labelPrefix + numClicks);
        button = new JButton("I'm a Swing button!");
        button.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(label);
        panel.add(button);
        add(panel);

        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        numClicks++;
        label.setText(labelPrefix + numClicks);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SwingApplication app = new SwingApplication();
            app.setVisible(true);
        });
    }
}

