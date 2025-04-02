package org.kelompok2;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class GameCanvas extends JPanel implements Runnable, KeyListener {
    private boolean running = true;
    private int score = 0; // Skor pemain
    private int lives = 3; // Jumlah nyawa pemain
    private int conqueredArea = 0; // Area yang dikuasai musuh
    private final int maxConqueredArea = 100; // Batas area yang dikuasai musuh
    private int level = 1; // Level permainan
    private boolean shieldActive = false; // Status perisai
    private int shieldDuration = 0; // Durasi perisai aktif
    private boolean laserActive = false; // Status laser
    private int laserDuration = 0; // Durasi laser aktif

    // Posisi dan ukuran pemain
    private int playerX = 375; // Posisi horizontal pemain
    private final int playerY = 500; // Posisi vertikal pemain (tetap)
    private final int playerSpeed = 10; // Kecepatan gerakan pemain

    // gambar pemain
    private Image playerSprite;

    // gambar latar belakang
    private Image background;
    private int backgroundY = 0; // posisi latar belakang

    // peluru
    private CopyOnWriteArrayList<Bullet> bullets = new CopyOnWriteArrayList<>(); // daftar peluru
    private final int bulletSpeed = 15; // kecepatan peluru

    // musuh
    private CopyOnWriteArrayList<Enemy> enemies = new CopyOnWriteArrayList<>(); // daftar musuh
    private int enemySpawnTimer = 0; // timer untuk spawn musuh

    // power-up
    private CopyOnWriteArrayList<PowerUp> powerUps = new CopyOnWriteArrayList<>(); // daftar power-up
    private int powerUpSpawnTimer = 0; // timer untuk spawn power-up

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

        // muat gambar latar belakang
        try {
            background = ImageIO.read(new File("assets/Background/space2_4-frames.png"));
        } catch (Exception e) {
            System.err.println("Gagal memuat gambar latar belakang: " + e.getMessage());
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
        for (Bullet bullet : bullets) {
            bullet.move();
            if (bullet.getY() < 0) {
                bullets.remove(bullet); // Hapus peluru yang keluar dari layar
            }
        }

        // Update posisi musuh
        for (Enemy enemy : enemies) {
            enemy.move();

            // tambahkan daerah yang dikuasai jika musuh mencapai area bawah
            if (enemy.getY() > getHeight()) {
                conqueredArea++; // Tambah area yang dikuasai
                enemies.remove(enemy); // Hapus musuh yang keluar dari layar
                continue; // lanjutkan ke iterasi berikutnya
            }

            // deteksi tabrakan antara musuh dan pemain
            if (enemy.getBounds().intersects(getPlayerBounds())) {
                if (!shieldActive) { // kurangi nyawa hanya jika shield tidak aktif
                    lives--; // Kurangi nyawa pemain
                }

                enemies.remove(enemy); // Hapus musuh yang bertabrakan dengan pemain
            }
        }

        // Deteksi tabrakan antara peluru dan musuh
        for (Bullet bullet : bullets) {
            for (Enemy enemy : enemies) {
                if (bullet.getX() < enemy.getX() + enemy.getWidth() && bullet.getX() + bullet.getWidth() > enemy.getX() && bullet.getY() < enemy.getY() + enemy.getHeight() && bullet.getY() + bullet.getHeight() > enemy.getY()) {
                    // Tabrakan terdeteksi, hapus peluru dan musuh
                    bullets.remove(bullet);
                    enemies.remove(enemy);

                    // Tambah point ke skor
                    score += 10; // Tambah skor

                    // keluar dari loop musuh setelah tabrakan
                    break;
                }
            }
        }

        // Update status power-up laser
        if (laserActive) {
            for (Enemy enemy : enemies) {
                if (enemy.getX() >= playerX && enemy.getX() <= playerX + 50) {
                    enemies.remove(enemy); // Hapus musuh yang terkena laser
                    score += 20; // Tambah skor
                }
            }
        }

        // Update status laser
        if (laserActive) {
            laserDuration--;
            if (laserDuration <= 0) {
                laserActive = false;
            }
        }

        // Update posisi power-up
        for (PowerUp powerUp : powerUps) {
            powerUp.move();

            // hapus power-up jika keluar dari layar
            if (!powerUp.isVisible()) {
                powerUps.remove(powerUp);
                continue;
            }

            // Deteksi tabrakan antara pemain dan power-up
            if (powerUp.getBounds().intersects(getPlayerBounds())) {
                switch (powerUp.getType()) {
                    case "life":
                        lives++; // Tambah nyawa
                        System.out.println("Life Power-Up Collected!");
                        break;
                    case "shield":
                        activateShield(); // Aktifkan perisai
                        System.out.println("Shield Power-Up Collected!");
                        break;
                    case "laser":
                        activateLaser(); // Aktifkan laser
                        System.out.println("Laser Power-Up Collected!");
                        break;
                }
                powerUps.remove(powerUp); // Hapus power-up setelah diambil
            }
        }

        // Spawn musuh baru setiap 100 frame
        enemySpawnTimer++;
        if (enemySpawnTimer >= 100) {
            int enemyX = (int) (Math.random() * (getWidth() - 50)); // Posisi acak
            enemies.add(new Enemy(enemyX, 0)); // Tambahkan musuh baru di atas layar
            enemySpawnTimer = 0;
        }

        // Spawn power-up setiap 300 frame (atau 5 detik pada 60 FPS)
        powerUpSpawnTimer++;
        if (powerUpSpawnTimer >= 300) {
            int powerUpX = (int) (Math.random() * (getWidth() - 30)); // Posisi acak
            String[] powerUpTypes = {"life", "shield", "laser"}; // Tipe power-up
            String randomType = powerUpTypes[(int) (Math.random() * powerUpTypes.length)]; // pilih tipe acak
            powerUps.add(new PowerUp(powerUpX, 0, randomType)); // Tambahkan power-up baru di atas layar
            powerUpSpawnTimer = 0; // Reset timer spawn power-up
        }

        // tingkatkan level setiap 100 poin
        if (score >= level * 100) {
            level++;
            System.out.println("Level Up! Level saat ini: " + level);

            // Tingkatkan kecepatan musuh
            for (Enemy enemy : enemies) {
                enemy.increaseSpeed(1); // Tingkatkan kecepatan musuh
            }
        }

        // Periksa apakah musuh telah menguasai area terlalu banyak
        if (conqueredArea >= maxConqueredArea) {
            gameOver(); // Tampilkan pesan game over
        }

        // Periksa apakah pemain kehabisan nyawa
        if (lives <= 0) {
            gameOver(); // Tampilkan pesan game over
        }

        // Update status perisai
        if (shieldActive) {
            shieldDuration--;
            if (shieldDuration <= 0) {
                shieldActive = false;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Gambar latar belakang
        if (background != null) {
            g.drawImage(background, 0, backgroundY, getWidth(), getHeight(), null);
            g.drawImage(background, 0, backgroundY - getHeight(), getWidth(), getHeight(), null);
        } else {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, getWidth(), getHeight());
        }

        // update posisi latar belakang
        backgroundY += 2; // Gerakkan latar belakang ke bawah
        if (backgroundY >= getHeight()) {
            backgroundY = 0; // Reset posisi latar belakang
        }

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

        // Gambar musuh
        g.setColor(Color.GREEN); // Gambar musuh berwarna hijau
        for (Enemy enemy : enemies) {
            g.fillRect(enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight());
        }

        // Gambar skor
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: " + score, 10, 20); // Gambar skor di pojok kiri atas

        // Gambar nyawa
        g.drawString("Lives: " + lives, 10, getHeight() - 10); // Gambar nyawa di pojok kiri bawah

        // Gambar area yang dikuasai
        String conqueredAreaText = "Conquered Area: " + conqueredArea + "/" + maxConqueredArea;
        int textWidth = g.getFontMetrics().stringWidth(conqueredAreaText); // Hitung lebar teks
        g.drawString(conqueredAreaText, getWidth() - textWidth - 10, 20); // Gambar teks di pojok kanan atas

        // Gambar power-up
        g.setColor(Color.YELLOW); // Gambar power-up berwarna kuning
        for (PowerUp powerUp : powerUps) {
            g.fillOval(powerUp.getX(), powerUp.getY(), powerUp.getWidth(), powerUp.getHeight());
        }

        // Gambar level
        g.drawString("Level: " + level, getWidth() / 2 - 40, 20); // Gambar level di tengah atas

        // Gambar status perisai
        if (shieldActive) {
            g.setColor(new Color(0, 0, 255, 100)); // Gambar perisai berwarna biru transparan
            g.fillOval(playerX - 10, playerY - 10, 70, 70); // Gambar lingkaran perisai di sekitar pemain
        }

        // gambar status laser
        if (laserActive) {
            g.setColor(Color.RED); // Gambar laser berwarna merah
            g.fillRect(playerX + 20, 0, 5, playerY); // Gambar laser dari pemain ke atas
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

    private Rectangle getPlayerBounds() {
        return new Rectangle(playerX, playerY, 50, 50); // Ukuran pemain
    }

    private void gameOver() {
        running = false; // Hentikan game loop
        JOptionPane.showMessageDialog(this, "Game Over! Your score: " + score, "Game Over", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0); // Keluar dari aplikasi
    }

    private void activateShield() {
        shieldActive = true; // Aktifkan perisai
        shieldDuration = 300; // Durasi perisai aktif (misalnya 5 detik)
    }

    private void activateLaser() {
        laserActive = true; // Aktifkan laser
        laserDuration = 150; // Durasi laser aktif selama 150 frame (misalnya 2,5 detik)
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

    // kelas musuh
    private static class Enemy {
        private int x, y;
        private final int width = 50, height = 50; // Ukuran musuh
        private int speed = 5; // Kecepatan musuh

        public Enemy(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void move() {
            y += speed; // Gerakkan musuh ke bawah
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

        public Rectangle getBounds() {
            return new Rectangle(x, y, width, height); // Ukuran musuh
        }

        public void increaseSpeed(int increment) {
            this.speed += increment; // Tingkatkan kecepatan musuh
        }
    }
}
