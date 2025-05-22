package manager;

import model.Bullet;
import model.Enemy;
import util.GameState;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class BulletManager {
    private ArrayList<Bullet> bullets = new ArrayList<>();
    private boolean laserMode = false;
    // TODO 1: menambahkan referensi ke EnemyManager
    private EnemyManager enemyManager;



    public void setLaserMode(boolean laserMode) {
        this.laserMode = laserMode;
    }

    public void addBullet(int x, int y) {
        if (laserMode) {
            // Tembakkan 3 peluru saat laser aktif
            bullets.add(new Bullet(x, y, 5, 15, Color.RED));
            bullets.add(new Bullet(x - 10, y, 5, 15, Color.RED));
            bullets.add(new Bullet(x + 10, y, 5, 15, Color.RED));
        } else {
            bullets.add(new Bullet(x, y, 5, 10, Color.WHITE));
        }
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
                    // TODO 2: menambahkan efek ledakan saat peluru mengenai musuh
                    if(enemyManager != null){
                        enemyManager.addExplosion(enemy.getX(), enemy.getY());
                    }

                    enemyIterator.remove();
                    // Laser memberikan skor lebih tinggi
                    if (laserMode) {
                        gameState.setScore(gameState.getScore() + 15); // Bonus skor untuk laser
                    } else {
                        gameState.setScore(gameState.getScore() + 10);
                    }
                    bulletIterator.remove();
                    bulletRemoved = true;
                    break;
                }
            }

            if (bulletRemoved) continue;
        }
    }

    public void drawBullets(Graphics g) {
        for (Bullet bullet : bullets) {
            bullet.draw(g);
        }
    }

    public ArrayList<Bullet> getBullets() {
        return bullets;
    }
}
