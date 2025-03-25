package Tugas.IV_1;

import java.awt.*;

public class FrameWithPanel {
    private Frame f;

    public FrameWithPanel(String title) {
        f = new Frame(title);
    }

    public void launchFrame() {
        f.setSize(300, 300);
        f.setBackground(Color.blue);
        f.setLayout(null);

        // Panel 1
        Panel pan1 = new Panel();
        pan1.setSize(100, 100);
        pan1.setLocation(20, 40);
        pan1.setBackground(Color.yellow);

        // Panel 2
        Panel pan2 = new Panel();
        pan2.setSize(80, 80);
        pan2.setLocation(140, 40);
        pan2.setBackground(Color.red);

        // Panel 3
        Panel pan3 = new Panel();
        pan3.setSize(100, 50);
        pan3.setLocation(80, 160);
        pan3.setBackground(Color.green);

        f.add(pan1);
        f.add(pan2);
        f.add(pan3);

        f.setVisible(true);
    }

    public static void main(String[] args) {
        FrameWithPanel guiWindow = new FrameWithPanel("Frame with Multiple Panels");
        guiWindow.launchFrame();
    }

}
