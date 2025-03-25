package Tugas.V_4;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CloseFrame extends Frame {
    Label label;
    CFListener w = new CFListener(this);

    CloseFrame(String title) {
        super(title);
        label = new Label("Close the frame.");
        this.addWindowListener(w);
    }

    void launchFrame() {
        setSize(300, 300);
        setVisible(true);
    }

    public static void main(String args[]) {
        CloseFrame cf = new CloseFrame("Close Window Example");
        cf.launchFrame();
    }
}

class CFListener extends WindowAdapter {
    CloseFrame ref;

    CFListener(CloseFrame ref) {
        this.ref = ref;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        ref.dispose();
        System.exit(1);
    }

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("Window opened.");
    }

    @Override
    public void windowIconified(WindowEvent e) {
        System.out.println("Window minimized.");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        System.out.println("Window restored.");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println("Window activated.");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        System.out.println("Window deactivated.");
    }
}