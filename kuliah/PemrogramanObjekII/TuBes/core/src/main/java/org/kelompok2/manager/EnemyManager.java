package org.kelompok2.manager;

import org.kelompok2.ui.GameCanvas;
import org.kelompok2.model.Enemy;
import org.kelompok2.util.GameState;

import java.awt.*;
import java.util.ArrayList;

public class EnemyManager {
    private ArrayList<Enemy> enemies = new ArrayList<>();
    private int spawnTimer = 0; // Timer untuk spawn musuh

    public void spawnEnemy(int canvasWidth) {
        spawnTimer++;
        if (spawnTimer >= 100) { // Spawn setiap 100 frame
            int x = (int) (Math.random() * canvasWidth); // Posisi acak
            int y = 50; // Posisi awal musuh di atas layar
            int width = 50, height = 50, speed = 5;

            // Pola gerakan acak
            String[] patterns = {"zigzag", "circle", "random", "default"};
            String movementPattern = patterns[(int) (Math.random() * patterns.length)];

            enemies.add(new Enemy(x, y, width, height, speed, movementPattern));
            spawnTimer = 0; // Reset timer
        }
    }

    public void updateEnemies(int canvasHeight, Rectangle playerBounds, boolean shieldActive, GameState gameState) {
        for (int i = 0; i < enemies.size(); i++) {
            Enemy enemy = enemies.get(i);
            enemy.move();

            // Hapus musuh jika keluar dari layar
            if (enemy.getY() > canvasHeight) {
                enemies.remove(i);
                i--;
                gameState.setConqueredArea(gameState.getConqueredArea() + 1);
                continue;
            }

            // Deteksi tabrakan dengan pemain
            if (enemy.getBounds().intersects(playerBounds)) {
                enemies.remove(i);
                i--;
                if (!shieldActive) {
                    gameState.setLives(gameState.getLives() - 1); // Kurangi nyawa pemain
                }
                gameState.setScore(gameState.getScore() + 10); // Tambahkan skor
            }
        }
    }


    public void drawEnemies(Graphics g) {
        g.setColor(Color.GREEN);
        for (Enemy enemy : enemies) {
            g.fillRect(enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight());
        }
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }
}
