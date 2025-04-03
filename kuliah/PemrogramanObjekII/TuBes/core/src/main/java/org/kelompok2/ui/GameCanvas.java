package org.kelompok2.ui;

import org.kelompok2.manager.*;
import org.kelompok2.model.Player;
import org.kelompok2.util.GameState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameCanvas extends JPanel implements Runnable, KeyListener {
    private boolean shieldActive = false;
    private int shieldDuration = 0;
    private boolean laserActive = false;
    private int laserDuration = 0;

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
        bulletManager.updateBullets(getHeight(), enemyManager.getEnemies(), gameState);
        enemyManager.spawnEnemy(getWidth());
        enemyManager.updateEnemies(getHeight(), player.getBounds(), shieldActive, gameState);
        powerUpManager.spawnPowerUp(getWidth());
        powerUpManager.updatePowerUps(player.getBounds(), gameState, this);

        if (gameState.getLevel() % 5 == 0 && !bossManager.isBossBattle()) {
            bossManager.spawnBoss(getWidth());
        }
        bossManager.updateBoss(bulletManager.getBullets(), gameState);

        // Update shield duration
        if (shieldActive) {
            shieldDuration--;
            if (shieldDuration <= 0) shieldActive = false;
        }

        // Update laser duration
        if (laserActive) {
            laserDuration--;
            if (laserDuration <= 0) laserActive = false;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        player.draw(g);
        bulletManager.drawBullets(g);
        enemyManager.drawEnemies(g);
        powerUpManager.drawPowerUps(g);
        bossManager.drawBoss(g);

        g.setColor(Color.BLACK);
        g.drawString("Score: " + gameState.getScore(), 10, 20);
        g.drawString("Lives: " + gameState.getLives(), 10, getHeight() - 10);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) player.moveLeft();
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) player.moveRight(getWidth());
        if (e.getKeyCode() == KeyEvent.VK_SPACE) bulletManager.addBullet(player.getX() + 20, player.getY());
    }

    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}
}
