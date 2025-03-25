package Tugas.V_5;

import java.awt.*;
import java.awt.event.*;

class CloseFrame extends Frame {
    Label label;
    Button button;

    CloseFrame(String title) {
        super(title);
        label = new Label("Close the frame.");
        button = new Button("Click Me");
        this.addWindowListener(new CFListener());
    }

    void launchFrame() {
        setLayout(new FlowLayout());
        add(label);
        add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked!");
            }
        });

        setSize(300, 300);
        setVisible(true);
    }

    class CFListener extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            dispose();
            System.exit(1);
        }
    }

    public static void main(String args[]) {
        CloseFrame cf = new CloseFrame("Close Window Example with Button");
        cf.launchFrame();
    }
}