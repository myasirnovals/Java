package manager;

import model.EnemyBullet;
import ui.GameCanvas;
import model.Enemy;
import util.GameState;

import java.awt.*;
import java.util.ArrayList;

public class EnemyManager {
    private ArrayList<Enemy> enemies = new ArrayList<>();
    private ArrayList<EnemyBullet> enemyBullets = new ArrayList<>();
    private int spawnTimer = 0;

    public void spawnEnemy(int canvasWidth) {
        spawnTimer++;
        if (spawnTimer >= 100) {
            int enemyWidth = 50; // sesuaikan dengan ukuran enemy kamu
            int x = (int) (Math.random() * (canvasWidth - enemyWidth));
            x = Math.max(x, 0); // memastikan posisi enemy tidak negatif
            enemies.add(new Enemy(x, 0, enemyWidth, 50, 3, "default"));
            spawnTimer = 0;
        }
    }

    public void updateEnemies(int canvasHeight, Rectangle playerBounds, boolean shieldActive, GameState gameState) {
        for (int i = 0; i < enemies.size(); i++) {
            Enemy enemy = enemies.get(i);
            enemy.move();

            if (enemy.isShooting() && Math.random() < 0.02) { // Peluang menembak acak
                enemyBullets.add(new EnemyBullet(enemy.getX() + enemy.getWidth() / 2, enemy.getY() + enemy.getHeight()));
            }

            if (enemy.getY() > canvasHeight) {
                enemies.remove(i);
                i--;
                gameState.increaseConqueredArea(1);
                continue;
            }

            if (enemy.getBounds().intersects(playerBounds)) {
                enemies.remove(i);
                i--;
                if (!shieldActive) {
                    gameState.decreaseLives();
                }
                gameState.setScore(gameState.getScore() + 10);
            }
        }

        // Update peluru musuh
        for (int i = 0; i < enemyBullets.size(); i++) {
            EnemyBullet bullet = enemyBullets.get(i);
            bullet.move();

            if (bullet.getY() > canvasHeight) {
                enemyBullets.remove(i);
                i--;
                continue;
            }

            if (bullet.getBounds().intersects(playerBounds)) {
                enemyBullets.remove(i);
                i--;
                if (!shieldActive) {
                    gameState.decreaseLives();
                }
            }
        }
    }

    public void drawEnemies(Graphics g) {
        g.setColor(Color.GREEN);
        for (Enemy enemy : enemies) {
            g.fillRect(enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight());
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

