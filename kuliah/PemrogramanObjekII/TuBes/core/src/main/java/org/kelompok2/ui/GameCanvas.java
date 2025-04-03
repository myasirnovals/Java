package org.kelompok2.ui;

import org.kelompok2.manager.*;
import org.kelompok2.model.Player;
import org.kelompok2.util.GameState;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class GameCanvas extends JPanel implements Runnable, KeyListener {
    private boolean shieldActive = false;
    private int shieldDuration = 0;
    private boolean laserActive = false;
    private int laserDuration = 0;
    private Image background;
    private boolean leftPressed = false;  // Tambahkan variabel untuk tracking tombol
    private boolean rightPressed = false; // Tambahkan variabel untuk tracking tombol

    private final GameState gameState;
    private final Player player;
    private final BulletManager bulletManager;
    private final EnemyManager enemyManager;
    private final PowerUpManager powerUpManager;
    private final BossManager bossManager;

    public GameCanvas() {
        gameState = new GameState();
        bulletManager = new BulletManager();
        enemyManager = new EnemyManager();
        powerUpManager = new PowerUpManager();
        bossManager = new BossManager();

        Image playerSprite = Toolkit.getDefaultToolkit().getImage("assets/Character/Ships/ship_0000.png");
        player = new Player(375, 500, 50, 50, 10, playerSprite);

        try {
            background = ImageIO.read(new File("assets/Background/space2_4-frames.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread gameThread = new Thread(this);
        gameThread.start();

        setFocusable(true);
        requestFocus();
        addKeyListener(this);
    }

    public void activateShield() {
        shieldActive = true;
        shieldDuration = 300; // contoh durasi shield aktif (5 detik)
    }

    public void activateLaser() {
        laserActive = true;
        laserDuration = 300; // contoh durasi laser aktif (5 detik)
        bulletManager.setLaserMode(true); // Pastikan bulletManager diset ke mode laser
    }

    @Override
    public void run() {
        while (true) {
            updateGame();
            repaint();
            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateGame() {
        // Jika game over, jangan update game
        if (gameState.isGameOver()) {
            return;
        }

        // Update player movement
        if (leftPressed) {
            player.moveLeft();
        }
        if (rightPressed) {
            player.moveRight(getWidth());
        }

        bulletManager.updateBullets(getHeight(), enemyManager.getEnemies(), gameState);
        enemyManager.spawnEnemy(getWidth());
        enemyManager.updateEnemies(getHeight(), player.getBounds(), shieldActive, gameState);
        powerUpManager.spawnPowerUp(getWidth());
        powerUpManager.updatePowerUps(player.getBounds(), gameState, this);

        // Cek kondisi conquered area
        if (gameState.getConqueredArea() >= gameState.getMaxConqueredArea()) {
            gameState.setGameOver(true);
            gameState.setGameOverReason("Area Fully Conquered");
            return;
        }

        if (gameState.getLevel() % 5 == 0 && !bossManager.isBossBattle()) {
            bossManager.spawnBoss(getWidth());
        }

        // Pastikan boss tidak null sebelum update
        if (bossManager.isBossBattle()) {
            bossManager.updateBoss(bulletManager.getBullets(), gameState);
        }

        // Update shield duration
        if (shieldActive) {
            shieldDuration--;
            if (shieldDuration <= 0) {
                shieldActive = false;
            }
        }

        // Update laser duration
        if (laserActive) {
            laserDuration--;
            if (laserDuration <= 0) {
                laserActive = false;
                bulletManager.setLaserMode(false); // Nonaktifkan mode laser
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Gambar background
        g2d.drawImage(background, 0, 0, getWidth(), getHeight(), this);

        // Gambar entitas game (player, bullets, enemies, dll)
        player.draw(g2d);
        bulletManager.drawBullets(g2d);
        enemyManager.drawEnemies(g2d);
        powerUpManager.drawPowerUps(g2d);

        // Pastikan boss tidak null sebelum menggambar
        if (bossManager.isBossBattle()) {
            bossManager.drawBoss(g2d);
        }

        // Set font untuk semua teks
        Font regularFont = new Font("Arial", Font.BOLD, 16);
        g2d.setFont(regularFont);

        // Score di pojok kiri atas
        g2d.setColor(Color.WHITE);
        g2d.drawString("Score: " + gameState.getScore(), 20, 25);

        // Level di tengah atas dengan warna kuning
        g2d.setColor(Color.YELLOW);
        String levelText = "Level: " + gameState.getLevel();
        FontMetrics fm = g2d.getFontMetrics();
        int levelWidth = fm.stringWidth(levelText);
        g2d.drawString(levelText, getWidth() / 2 - levelWidth / 2, 25);

        // High Score di bawah Level dengan warna kuning juga
        String highScoreText = "High Score: " + gameState.getHighScore();
        int highScoreWidth = fm.stringWidth(highScoreText);
        g2d.drawString(highScoreText, getWidth() / 2 - highScoreWidth / 2, 50);

        // Conquered Area di pojok kanan atas
        g2d.setColor(Color.WHITE);
        String areaText = "Conquered Area: " + gameState.getConqueredArea() + "/" + gameState.getMaxConqueredArea();
        int areaWidth = fm.stringWidth(areaText);
        g2d.drawString(areaText, getWidth() - areaWidth - 20, 25);

        // Lives di pojok kiri bawah
        g2d.setColor(Color.WHITE);
        g2d.drawString("Lives: " + gameState.getLives(), 20, getHeight() - 20);

        // Tampilkan status shield dan laser jika aktif
        if (shieldActive) {
            g2d.setColor(Color.BLUE);
            g2d.drawString("Shield Active: " + shieldDuration / 60 + "s", 20, getHeight() - 40);

            // Gambar efek shield di sekitar player
            g2d.setColor(new Color(0, 0, 255, 100)); // Biru transparan
            g2d.fillOval(player.getX() - 5, player.getY() - 5, player.getWidth() + 10, player.getHeight() + 10);
        }

        if (laserActive) {
            g2d.setColor(Color.RED);
            g2d.drawString("Laser Active: " + laserDuration / 60 + "s", 20, getHeight() - 60);
        }

        // Jika game over
        if (gameState.isGameOver()) {
            Font gameOverFont = new Font("Arial", Font.BOLD, 40);
            g2d.setFont(gameOverFont);
            g2d.setColor(Color.RED);
            String gameOverText = "GAME OVER";
            fm = g2d.getFontMetrics();
            int gameOverWidth = fm.stringWidth(gameOverText);
            g2d.drawString(gameOverText, getWidth() / 2 - gameOverWidth / 2, getHeight() / 2 - 40);

            // Tambahkan alasan game over
            Font reasonFont = new Font("Arial", Font.BOLD, 24);
            g2d.setFont(reasonFont);
            g2d.setColor(Color.YELLOW);
            String reasonText = gameState.getGameOverReason();
            fm = g2d.getFontMetrics();
            int reasonWidth = fm.stringWidth(reasonText);
            g2d.drawString(reasonText, getWidth() / 2 - reasonWidth / 2, getHeight() / 2);

            // Tampilkan skor akhir
            Font scoreFont = new Font("Arial", Font.BOLD, 30);
            g2d.setFont(scoreFont);
            g2d.setColor(Color.WHITE);
            String finalScoreText = "Final Score: " + gameState.getScore();
            fm = g2d.getFontMetrics();
            int scoreWidth = fm.stringWidth(finalScoreText);
            g2d.drawString(finalScoreText, getWidth() / 2 - scoreWidth / 2, getHeight() / 2 + 40);

            // Tampilkan high score
            String highScoreText2 = "High Score: " + gameState.getHighScore();
            fm = g2d.getFontMetrics();
            int highScoreWidth2 = fm.stringWidth(highScoreText2);
            g2d.drawString(highScoreText2, getWidth() / 2 - highScoreWidth2 / 2, getHeight() / 2 + 80);

            // Instruksi untuk memulai ulang
            Font instructionFont = new Font("Arial", Font.PLAIN, 20);
            g2d.setFont(instructionFont);
            g2d.setColor(Color.GREEN);
            String instructionText = "Press 'R' to Restart or 'ESC' to Exit";
            fm = g2d.getFontMetrics();
            int instructionWidth = fm.stringWidth(instructionText);
            g2d.drawString(instructionText, getWidth() / 2 - instructionWidth / 2, getHeight() / 2 + 130);
        }
    }

    // Method untuk me-reset game
    public void resetGame() {
        gameState.setScore(0);
        gameState.setLives(3);
        gameState.setLevel(1);
        gameState.setConqueredArea(0);
        gameState.setGameOver(false);
        gameState.setGameOverReason("");

        // Reset posisi player
        player.setX(375);
        player.setY(500);

        // Bersihkan semua entitas
        bulletManager.getBullets().clear();
        enemyManager.getEnemies().clear();
        powerUpManager.getPowerUps().clear();
        bossManager.resetBoss();

        // Reset status power-up
        shieldActive = false;
        shieldDuration = 0;
        laserActive = false;
        laserDuration = 0;
        bulletManager.setLaserMode(false);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (gameState.isGameOver()) {
            if (key == KeyEvent.VK_R) {
                resetGame();
            } else if (key == KeyEvent.VK_ESCAPE) {
                System.exit(0);
            }
            return;
        }

        if (key == KeyEvent.VK_LEFT) {
            leftPressed = true;
        } else if (key == KeyEvent.VK_RIGHT) {
            rightPressed = true;
        } else if (key == KeyEvent.VK_SPACE) {
            bulletManager.addBullet(player.getX() + player.getWidth() / 2 - 2, player.getY());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            leftPressed = false;
        } else if (key == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Tidak diimplementasikan
    }
}
