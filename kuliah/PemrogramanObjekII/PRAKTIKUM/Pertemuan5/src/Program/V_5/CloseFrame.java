package Program.V_5;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class CloseFrame extends Frame {
    Label label;

    CloseFrame(String title) {
        super(title);
        label = new Label("Close the frame.");
        this.addWindowListener(new CFListener());
    }

    void launchFrame() {
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
        CloseFrame cf = new CloseFrame("Close Window Example");
        cf.launchFrame();
    }
}
