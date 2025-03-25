package Tugas.IV_2;

import java.awt.*;

public class GraphicPanel extends Panel {
    public GraphicPanel() {
        setBackground(Color.black); // Warna latar belakang panel
    }

    public void paint(Graphics g) {
        g.setColor(new Color(0, 255, 0));
        g.setFont(new Font("Helvetica", Font.PLAIN, 16));
        g.drawString("Hello GUI World!", 30, 50);

        g.setColor(Color.blue);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("This is Bold Text!", 30, 80);

        g.setColor(Color.red);
        g.setFont(new Font("Times New Roman", Font.ITALIC, 18));
        g.drawString("Italicized Text Example", 30, 110);

        g.setColor(Color.yellow);
        g.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 22));
        g.drawString("Bold & Italic Text!", 30, 140);

        g.setColor(new Color(128, 0, 128));
        g.setFont(new Font("Verdana", Font.PLAIN, 26));
        g.drawString("Large Font Example", 30, 180);
    }

    public static void main(String[] args) {
        Frame f = new Frame("Testing Graphics Panel with Styles");
        GraphicPanel gp = new GraphicPanel();
        f.add(gp);
        f.setSize(600, 300);
        f.setVisible(true);
    }
}
