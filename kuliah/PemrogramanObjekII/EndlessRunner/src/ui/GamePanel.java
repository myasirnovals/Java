package ui;

import model.Player;
import model.Ground;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements KeyListener {
    private Player player;
    private Ground ground;

    public GamePanel() {
        // Inisialisasi pemain dan tanah
        player = new Player(100, 615, 71, 139); // Posisi awal pemain
        ground = new Ground(0, 750, Toolkit.getDefaultToolkit().getScreenSize().width * 2, 300); // Tanah sepanjang 2x lebar layar

        // Tambahkan KeyListener untuk menangani input
        addKeyListener(this);
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Gambar tanah
        ground.render(g);

        // Render pemain
        player.render(g);
    }

    public void update() {
        // Update pemain dan tanah
        player.update();
        ground.update();
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
