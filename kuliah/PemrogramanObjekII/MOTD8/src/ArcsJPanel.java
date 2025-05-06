import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

public class ArcsJPanel extends JPanel {
    // draw rectangles and arcs
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // call superclass's paintComponent

        // Start at 0 and sweep 360 degrees
        g.setColor(Color.RED);
        g.drawRect(15, 35, 80, 80); // outline rectangle
        g.setColor(Color.BLACK);
        g.drawArc(15, 35, 80, 80, 0, 360); // full circle arc

        // Start at 0 and sweep 110 degrees
        g.setColor(Color.RED);
        g.drawRect(100, 35, 80, 80); // outline rectangle
        g.setColor(Color.BLACK);
        g.drawArc(100, 35, 80, 80, 0, 110); // partial arc

        // Start at 0 and sweep -270 degrees
        g.setColor(Color.RED);
        g.drawRect(185, 35, 80, 80); // outline rectangle
        g.setColor(Color.BLACK);
        g.drawArc(185, 35, 80, 80, 0, -270); // counter-clockwise arc

        // Filled arcs
        // Start at 0 and sweep 360 degrees
        g.fillArc(15, 120, 80, 40, 0, 360); // filled oval

        // Start at 270 and sweep -90 degrees
        g.fillArc(100, 120, 80, 40, 270, -90); // filled arc

        // Start at 0 and sweep -270 degrees
        g.fillArc(185, 120, 80, 40, 0, -270); // filled arc
    } // end method paintComponent

    public static void main(String[] args) {
        // Membuat frame (jendela)
        JFrame frame = new JFrame("Arcs and Rectangles");

        // Menambahkan panel ke frame
        ArcsJPanel panel = new ArcsJPanel();
        frame.add(panel);

        // Mengatur ukuran frame
        frame.setSize(300, 250);

        // Menentukan aksi saat jendela ditutup
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Menampilkan frame
        frame.setVisible(true);
    }
} // end class ArcsJPanel
