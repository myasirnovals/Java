package manager;

import model.Boss;
import model.BossBullet;
import model.Bullet;
import model.Player;
import util.GameState;

import java.awt.*;
import java.util.List;

public class BossManager {
    private Boss boss;
    private boolean bossBattle;

    public void spawnBoss(int canvasWidth, int bossLevel) { // Tambahkan parameter bossLevel
        boss = new Boss(canvasWidth / 2 - 50, 50, bossLevel); // Teruskan level bos ke konstruktor
        bossBattle = true;
    }

    public void updateBoss(List<Bullet> bullets, GameState gameState, Player player, int canvasWidth) {
        if (!bossBattle) return;

        boss.update(canvasWidth);

        // Cek peluru pemain mengenai boss
        bullets.removeIf(bullet -> {
            if (boss.getBounds().intersects(bullet.getBounds())) {
                boss.hit();
                return true;
            }
            return false;
        });

        // Cek peluru boss mengenai pemain
        List<BossBullet> bossBullets = boss.getBullets();
        bossBullets.removeIf(bossBullet -> {
            if (bossBullet.getBounds().intersects(player.getBounds())) {
                gameState.setLives(gameState.getLives() - 1); // Kurangi nyawa pemain
                return true;
            }
            return false;
        });

        if (boss.isDead()) {
            bossBattle = false;
        }
    }

    public boolean checkBossDefeat(GameState gameState) {
        if (boss != null && boss.isDead()) {
            bossBattle = false;
            boss = null;
            // Naikkan level ketika boss dikalahkan
            gameState.setLevel(gameState.getLevel() + 1);
            return true;
        }
        return false;
    }

    public void drawBoss(Graphics g) {
        if (bossBattle) {
            boss.draw(g);
        }
    }

    public boolean isBossBattle() {
        return bossBattle;
    }

    public void resetBoss() {
        boss = null;
        bossBattle = false;
    }
}
