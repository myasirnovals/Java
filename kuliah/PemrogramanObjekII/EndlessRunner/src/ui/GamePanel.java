package ui;

import model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements KeyListener {
    private Player player;

    public GamePanel() {
        // Inisialisasi pemain
        player = new Player(100, 615, 71, 139);

        // Tambahkan KeyListener untuk menangani input
        addKeyListener(this);
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // gambar garis merah (lantai)
        g.setColor(Color.RED);
        g.drawLine(0, 750, getWidth(), 750); // Garis horizontal di posisi 750

        // Render pemain
        player.render(g);
    }

    public void update() {
        // Update pemain
        player.update();
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            player.jump(); // Pemain melompat saat tombol spasi ditekan
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}
