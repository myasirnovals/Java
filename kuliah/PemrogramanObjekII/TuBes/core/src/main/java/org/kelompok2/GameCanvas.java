package org.kelompok2;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class GameCanvas extends JPanel implements Runnable, KeyListener {
    private boolean running = true;

    // Posisi dan ukuran pemain
    private int playerX = 375; // Posisi horizontal pemain
    private final int playerY = 500; // Posisi vertikal pemain (tetap)
    private final int playerSpeed = 10; // Kecepatan gerakan pemain

    // gambar pemain
    private Image playerSprite;

    // peluru
    private ArrayList<Bullet> bullets = new ArrayList<>(); // daftar peluru
    private final int bulletSpeed = 15; // kecepatan peluru

    public GameCanvas() {
        // Mulai game loop di thread baru
        Thread gameThread = new Thread(this);
        gameThread.start();

        // Tambahkan KeyListener untuk menangkap input keyboard
        setFocusable(true);
        requestFocus();
        addKeyListener(this);

        // muat gambar pemain
        try {
            playerSprite = ImageIO.read(new File("assets/Character/Ships/ship_0000.png"));
        } catch (Exception e) {
            System.err.println("Gagal memuat gambar pemain: " + e.getMessage());
        }
    }

    @Override
    public void run() {
        while (running) {
            updateGame(); // Perbarui logika game
            repaint();    // Gambar ulang layar

            try {
                Thread.sleep(16); // ~60 FPS
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateGame() {
        // Update posisi peluru
        Iterator<Bullet> iterator = bullets.iterator();
        while (iterator.hasNext()) {
            Bullet bullet = iterator.next();
            bullet.move();

            // Hapus peluru jika keluar dari layar
            if (bullet.getY() < 0) {
                iterator.remove();
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Atur warna latar belakang
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Gambar pemain (sprite)
        if (playerSprite != null) {
            g.drawImage(playerSprite, playerX, playerY, null);
        } else {
            g.setColor(Color.WHITE);
            g.fillRect(playerX, playerY, 50, 50); // Gambar kotak putih sebagai pemain
        }

        // Gambar peluru
        g.setColor(Color.RED); // Gambar peluru berwarna merah
        for (Bullet bullet : bullets) {
            g.fillRect(bullet.getX(), bullet.getY(), bullet.getWidth(), bullet.getHeight());
        }
    }

    // Metode KeyListener
    @Override
    public void keyPressed(KeyEvent e) {
        // Tangkap input tombol panah kiri
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            playerX -= playerSpeed;
            if (playerX < 0) playerX = 0; // Jangan keluar dari layar di kiri
        }
        // Tangkap input tombol panah kanan
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            playerX += playerSpeed;
            if (playerX > getWidth() - 50) playerX = getWidth() - 50; // Jangan keluar dari layar di kanan
        }
        // tangkap input tombol spasi untuk menembak
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            bullets.add(new Bullet(playerX + 20, playerY)); // Tambahkan peluru baru
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Tidak digunakan untuk sekarang
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Tidak digunakan untuk sekarang
    }

    // kelas peluru
    private static class Bullet {
        private int x, y;
        private final int width = 5, height = 10;

        public Bullet(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void move() {
            y -= 15; // Gerakkan peluru ke atas
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }
    }
}
