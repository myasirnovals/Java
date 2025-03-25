package Program.V_6;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CloseFrame extends Frame {
    Label label;

    CloseFrame(String title) {
        super(title);
        label = new Label("Close the frame.");
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(1);
            }
        });
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
