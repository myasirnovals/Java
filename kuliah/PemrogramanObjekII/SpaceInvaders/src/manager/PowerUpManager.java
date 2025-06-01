package manager;

import ui.GameCanvas;
import model.PowerUp;
import util.GameState;

import java.awt.*;
import java.util.ArrayList;

public class PowerUpManager {
    private ArrayList<PowerUp> powerUps = new ArrayList<>();
    private int spawnTimer = 0;

    public void spawnPowerUp(int canvasWidth) {
        spawnTimer++;
        if (spawnTimer >= 300) {
            int x = (int) (Math.random() * (canvasWidth - 30));
            String[] types = {"life", "shield", "laser"};
            String type = types[(int) (Math.random() * types.length)];
            powerUps.add(new PowerUp(x, 0, type));
            spawnTimer = 0;
        }
    }

    public void updatePowerUps(Rectangle playerBounds, GameState gameState, GameCanvas canvas) {
        for (int i = 0; i < powerUps.size(); i++) {
            PowerUp powerUp = powerUps.get(i);
            powerUp.move();

            if (!powerUp.isVisible()) {
                powerUps.remove(i);
                i--;
                continue;
            }

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
        for (PowerUp powerUp : powerUps) {
            powerUp.draw(g);
        }
    }

    public ArrayList<PowerUp> getPowerUps() {
        return powerUps;
    }
}
