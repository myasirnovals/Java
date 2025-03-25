package Program.V_7;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class BMICalculator extends JFrame {
    private final JTextField txtMass = makePrettyTextField();
    private final JTextField txtHeight = makePrettyTextField();
    private final JButton btnCalc = makePrettyButton("Calculate BMI");
    private final BMICalculator self = this;

    public BMICalculator() {
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("BMI Calculator");
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        txtMass.setPreferredSize(new Dimension(200, 30));
        txtHeight.setPreferredSize(new Dimension(200, 30));
        txtMass.setMaximumSize(txtMass.getPreferredSize());
        txtHeight.setMaximumSize(txtHeight.getPreferredSize());
        getContentPane().setBackground(new Color(232, 240, 255));
        getContentPane().add(makePrettyLabel("Your mass (kg):"));
        getContentPane().add(Box.createRigidArea(new Dimension(5, 5)));
        getContentPane().add(txtMass);
        getContentPane().add(Box.createRigidArea(new Dimension(5, 5)));
        getContentPane().add(Box.createVerticalGlue());
        getContentPane().add(makePrettyLabel("Your height (cm):"));
        getContentPane().add(Box.createRigidArea(new Dimension(5, 5)));
        getContentPane().add(txtHeight);
        getContentPane().add(Box.createRigidArea(new Dimension(5, 5)));
        getContentPane().add(Box.createVerticalGlue());
        getContentPane().add(btnCalc);
        getContentPane().add(Box.createRigidArea(new Dimension(5, 5)));
        // Add BMI calculation
        btnCalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                double mass;
                double height;
                try {
                    mass = Double.parseDouble(txtMass.getText());
                    height = Double.parseDouble(txtHeight.getText());
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(self, "Please enter a valid number for mass and height.", "Input error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                double result = calculateBMI(mass, height);
                JOptionPane.showMessageDialog(self, "Your BMI is: " + (Math.round(result * 100.0) / 100.0), "Your BMI result", JOptionPane.PLAIN_MESSAGE);
            }
        });
        pack();
        setVisible(true);
    }

    protected double calculateBMI(double mass, double height) {
        return mass / Math.pow(height / 100.0, 2.0);
    }

    private JButton makePrettyButton(String title) {
        JButton button = new JButton(title);
        button.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));

        button.setBorder(BorderFactory.createRaisedBevelBorder());
        button.setBackground(Color.white);
        button.setForeground(new Color(53, 124, 255));
        return button;
    }

    private JTextField makePrettyTextField() {
        JTextField field = new JTextField();
        field.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 14));
        field.setHorizontalAlignment(JTextField.RIGHT);

        field.setBorder(BorderFactory.createLoweredBevelBorder());
        return field;
    }

    private JLabel makePrettyLabel(String title) {
        JLabel label = new JLabel(title);
        label.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
        label.setForeground(new Color(53, 124, 255));
        return label;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BMICalculator();
            }
        });
    }
}

