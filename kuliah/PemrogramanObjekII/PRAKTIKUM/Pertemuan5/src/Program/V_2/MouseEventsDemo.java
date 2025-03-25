package Program.V_2;

import java.awt.*;
import java.awt.event.*;

public class MouseEventsDemo extends Frame implements MouseListener,
        MouseMotionListener {
    TextField tf;

    public MouseEventsDemo(String title) {
        super(title);
        tf = new TextField(60);
        addMouseListener(this);
    }

    public void launchFrame() {
        /* Menambah komponen pada frame */
        add(tf, BorderLayout.SOUTH);
        setSize(300, 300);
        setVisible(true);
    }

    public void mouseClicked(MouseEvent me) {
        String msg = "Mouse clicked.";
        tf.setText(msg);
    }

    public void mouseEntered(MouseEvent me) {
        String msg = "Mouse entered component.";
        tf.setText(msg);
    }

    //Dan seterusnya lengkapi untuk overriding method nya
    public static void main(String args[]) {
        MouseEventsDemo med = new MouseEventsDemo("Mouse Events Demo");
        med.launchFrame();
    }
}
