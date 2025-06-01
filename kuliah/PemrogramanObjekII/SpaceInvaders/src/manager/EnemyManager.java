package manager;

import model.EnemyBullet;
import model.ExplosionEffect;
import ui.GameCanvas;
import model.Enemy;
import util.GameState;
import util.SoundPlayer;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class EnemyManager {
    private ArrayList<Enemy> enemies = new ArrayList<>();
    private ArrayList<EnemyBullet> enemyBullets = new ArrayList<>();
    private ExplosionManager explosionManager;

    private int spawnTimer = 0;
    private int spawnInterval = 100;

    public void setExplosionManager(ExplosionManager explosionManager) {
        this.explosionManager = explosionManager;
    }

    public void addExplosion(int x, int y) {
        if (explosionManager != null) {
            explosionManager.addExplosion(x, y);
        }
    }

    public void increaseEnemySpeed(int level) {
        for (Enemy enemy : enemies) {
            enemy.increaseSpeed(1);
        }
    }

    public void increaseSpawnRate(int level) {
        spawnInterval = Math.max(30, 100 - (level * 10));
    }

    public void spawnEnemy(int canvasWidth) {
        spawnTimer++;
        if (spawnTimer >= spawnInterval) {
            int enemyWidth = 50;
            int x = (int) (Math.random() * (canvasWidth - enemyWidth));
            x = Math.max(x, 0);
            enemies.add(new Enemy(x, 0, enemyWidth, 50, 3, "default"));
            spawnTimer = 0;
        }
    }

    public void updateEnemies(int canvasHeight, Rectangle playerBounds, boolean shieldActive, GameState gameState) {
        for (int i = 0; i < enemies.size(); i++) {
            Enemy enemy = enemies.get(i);
            enemy.move();

            if (enemy.isShooting() && Math.random() < 0.02) {
                enemyBullets.add(new EnemyBullet(enemy.getX() + enemy.getWidth() / 2, enemy.getY() + enemy.getHeight()));
                SoundPlayer.playSound("assets/SoundTrack/enemy_shot.wav");
            }

            if (enemy.getY() > canvasHeight) {
                enemies.remove(i);
                i--;
                gameState.increaseConqueredArea(1);
                continue;
            }

            if (enemy.getBounds().intersects(playerBounds)) {
                if (explosionManager != null) {
                    explosionManager.addExplosion(enemy.getX(), enemy.getY());
                }

                if (!shieldActive) {
                    gameState.decreaseLives();
                }

                SoundPlayer.playSound("assets/SoundTrack/explosive.wav");
                enemies.remove(i);
                i--;
                gameState.setScore(gameState.getScore() + 10);
            }
        }

        for (int i = 0; i < enemyBullets.size(); i++) {
            EnemyBullet bullet = enemyBullets.get(i);
            bullet.move();

            if (bullet.getY() > canvasHeight) {
                enemyBullets.remove(i);
                i--;
                continue;
            }

            if (bullet.getBounds().intersects(playerBounds)) {
                if (explosionManager != null) {
                    explosionManager.addExplosion(bullet.getX() - 25, bullet.getY() - 25);
                }

                if (!shieldActive) {
                    gameState.decreaseLives();
                }

                SoundPlayer.playSound("assets/SoundTrack/explosive.wav");
                enemyBullets.remove(i);
                i--;
            }
        }
    }

    public void drawEnemies(Graphics g) {
        for (Enemy enemy : enemies) {
            if (enemy != null) {
                g.drawImage(enemy.getSprite(), enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight(), null);
            }
        }

        for (EnemyBullet bullet : enemyBullets) {
            bullet.draw(g);
        }
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public ArrayList<EnemyBullet> getEnemyBullets() {
        return enemyBullets;
    }
}

