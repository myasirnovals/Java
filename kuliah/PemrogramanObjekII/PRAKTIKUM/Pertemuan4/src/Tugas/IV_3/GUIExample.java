package Tugas.IV_3;

import java.awt.*;
import java.awt.event.*;

public class GUIExample {
    public static void main(String[] args) {
        Frame frame = new Frame("GUI example");

        frame.setLayout(new GridLayout(1, 2));

        Button pressMeButton = new Button("Press Me");
        pressMeButton.setFont(new Font("Arial", Font.PLAIN, 12));

        Button dontPressMeButton = new Button("Don't press Me");
        dontPressMeButton.setFont(new Font("Arial", Font.PLAIN, 12));

        frame.add(pressMeButton);
        frame.add(dontPressMeButton);
        frame.setSize(300, 100);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }
}