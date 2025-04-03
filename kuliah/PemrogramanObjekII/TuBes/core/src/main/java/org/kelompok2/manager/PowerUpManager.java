package org.kelompok2.manager;

import org.kelompok2.ui.GameCanvas;
import org.kelompok2.model.PowerUp;
import org.kelompok2.util.GameState;

import java.awt.*;
import java.util.ArrayList;

public class PowerUpManager {
    private ArrayList<PowerUp> powerUps = new ArrayList<>();
    private int spawnTimer = 0;

    public void spawnPowerUp(int canvasWidth) {
        spawnTimer++;
        if (spawnTimer >= 300) { // Spawn setiap 300 frame
            int x = (int) (Math.random() * (canvasWidth - 30)); // Posisi acak
            String[] types = {"life", "shield", "laser"};
            String type = types[(int) (Math.random() * types.length)];
            powerUps.add(new PowerUp(x, 0, type));
            spawnTimer = 0; // Reset timer
        }
    }

    public void updatePowerUps(Rectangle playerBounds, GameState gameState, GameCanvas canvas) {
        for (int i = 0; i < powerUps.size(); i++) {
            PowerUp powerUp = powerUps.get(i);
            powerUp.move();

            // Hapus power-up jika keluar dari layar
            if (!powerUp.isVisible()) {
                powerUps.remove(i);
                i--;
                continue;
            }

            // Deteksi tabrakan dengan pemain
            if (powerUp.getBounds().intersects(playerBounds)) {
                switch (powerUp.getType()) {
                    case "life":
                        gameState.setLives(gameState.getLives() + 1);
                        break;
                    case "shield":
                        canvas.activateShield();
                        break;
                    case "laser":
                        canvas.activateLaser();
                        break;
                }
                powerUps.remove(i);
                i--;
            }
        }
    }


    public void drawPowerUps(Graphics g) {
        g.setColor(Color.YELLOW);
        for (PowerUp powerUp : powerUps) {
            g.fillOval(powerUp.getX(), powerUp.getY(), powerUp.getWidth(), powerUp.getHeight());
        }
    }
}

