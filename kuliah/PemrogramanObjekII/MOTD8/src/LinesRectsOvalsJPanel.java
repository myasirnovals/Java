import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

public class LinesRectsOvalsJPanel extends JPanel {
    // display various lines, rectangles, and ovals
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // call superclass's paint method
        this.setBackground(Color.WHITE);

        // Draw a red line
        g.setColor(Color.RED);
        g.drawLine(5, 30, 380, 30);

        // Draw rectangles
        g.setColor(Color.BLUE);
        g.drawRect(5, 40, 90, 55); // outlined rectangle
        g.fillRect(100, 40, 90, 55); // filled rectangle

        // Draw rounded rectangles
        g.setColor(Color.CYAN);
        g.fillRoundRect(195, 40, 90, 55, 50, 50); // filled rounded rectangle
        g.drawRoundRect(290, 40, 90, 55, 20, 20); // outlined rounded rectangle

        // Draw 3D rectangles
        g.setColor(Color.YELLOW);
        g.draw3DRect(5, 100, 90, 55, true); // outlined 3D rectangle
        g.fill3DRect(100, 100, 90, 55, false); // filled 3D rectangle

        // Draw ovals
        g.setColor(Color.MAGENTA);
        g.drawOval(195, 100, 90, 55); // outlined oval
        g.fillOval(290, 100, 90, 55); // filled oval
    } // end method paintComponent

    public static void main(String[] args) {
        // Membuat frame (jendela)
        JFrame frame = new JFrame("Lines, Rectangles, and Ovals");

        // Menambahkan panel ke frame
        LinesRectsOvalsJPanel panel = new LinesRectsOvalsJPanel();
        frame.add(panel);

        // Mengatur ukuran frame
        frame.setSize(400, 250);

        // Menentukan aksi saat jendela ditutup
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Menampilkan frame
        frame.setVisible(true);
    }
} // end class LinesRectsOvalsJPanel
