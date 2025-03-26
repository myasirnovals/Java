package Tugas.TA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JPopupMenuExample extends JFrame {
    private JPanel panel;

    public JPopupMenuExample() {
        setTitle("Using JPopupMenus");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setBackground(Color.WHITE);

        JPopupMenu popupMenu = new JPopupMenu();

        JRadioButtonMenuItem blueItem = new JRadioButtonMenuItem("Blue");
        JRadioButtonMenuItem yellowItem = new JRadioButtonMenuItem("Yellow");
        JRadioButtonMenuItem redItem = new JRadioButtonMenuItem("Red");

        ButtonGroup group = new ButtonGroup();
        group.add(blueItem);
        group.add(yellowItem);
        group.add(redItem);

        popupMenu.add(blueItem);
        popupMenu.add(yellowItem);
        popupMenu.add(redItem);

        blueItem.addActionListener(e -> panel.setBackground(Color.BLUE));
        yellowItem.addActionListener(e -> panel.setBackground(Color.YELLOW));
        redItem.addActionListener(e -> panel.setBackground(Color.RED));

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popupMenu.show(panel, e.getX(), e.getY());
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popupMenu.show(panel, e.getX(), e.getY());
                }
            }
        });

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JPopupMenuExample frame = new JPopupMenuExample();
            frame.setVisible(true);
        });
    }
}

