package org.kelompok2.manager;

import org.kelompok2.model.Bullet;
import org.kelompok2.model.Enemy;
import org.kelompok2.util.GameState;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class BulletManager {
    private ArrayList<Bullet> bullets = new ArrayList<>();

    public void addBullet(int x, int y) {
        bullets.add(new Bullet(x, y));
    }

    public void updateBullets(int canvasHeight, ArrayList<Enemy> enemies, GameState gameState) {
        Iterator<Bullet> bulletIterator = bullets.iterator();
        while (bulletIterator.hasNext()) {
            Bullet bullet = bulletIterator.next();
            bullet.move();

            boolean bulletRemoved = false;

            if (bullet.getY() < 0) {
                bulletIterator.remove();
                continue;
            }

            Iterator<Enemy> enemyIterator = enemies.iterator();
            while (enemyIterator.hasNext()) {
                Enemy enemy = enemyIterator.next();

                if (bullet.getBounds().intersects(enemy.getBounds())) {
                    enemyIterator.remove();
                    gameState.setScore(gameState.getScore() + 10);
                    bulletIterator.remove();
                    bulletRemoved = true;
                    break;
                }
            }

            if (bulletRemoved) continue;
        }
    }

    public void drawBullets(Graphics g) {
        g.setColor(Color.RED);
        for (Bullet bullet : bullets) {
            g.fillRect(bullet.getX(), bullet.getY(), bullet.getWidth(), bullet.getHeight());
        }
    }

    // Method tambahan
    public ArrayList<Bullet> getBullets() {
        return bullets;
    }
}
