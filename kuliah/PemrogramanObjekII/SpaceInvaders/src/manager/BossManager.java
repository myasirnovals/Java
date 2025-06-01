package manager;

import model.Boss;
import model.BossBullet;
import model.Bullet;
import model.Player;
import util.GameState;
import util.SoundPlayer;

import java.awt.*;
import java.util.List;

public class BossManager {
    private Boss boss;
    private boolean bossBattle;
    private ExplosionManager explosionManager;

    public void setExplosionManager(ExplosionManager explosionManager) {
        this.explosionManager = explosionManager;
    }

    public void spawnBoss(int canvasWidth, int bossLevel) {
        boss = new Boss(canvasWidth / 2 - 50, 50, bossLevel);
        bossBattle = true;
    }

    public void updateBoss(List<Bullet> bullets, GameState gameState, Player player, int canvasWidth) {
        if (!bossBattle) return;

        boss.update(canvasWidth);

        bullets.removeIf(bullet -> {
            if (boss.getBounds().intersects(bullet.getBounds())) {
                if (explosionManager != null) {
                    SoundPlayer.playSound("assets/SoundTrack/explosive.wav");
                    explosionManager.addExplosion(bullet.getX(), bullet.getY());
                }

                boss.hit();
                return true;
            }
            return false;
        });

        List<BossBullet> bossBullets = boss.getBullets();
        bossBullets.removeIf(bossBullet -> {
            if (bossBullet.getBounds().intersects(player.getBounds())) {
                if (explosionManager != null) {
                    SoundPlayer.playSound("assets/SoundTrack/explosive.wav");
                    explosionManager.addExplosion(player.getX() + player.getWidth() / 2, player.getY() + player.getHeight() / 2);
                }

                gameState.setLives(gameState.getLives() - 1);
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
            if (explosionManager != null) {
                for (int i = 0; i < 5; i++) {
                    int offsetX = (int) (Math.random() * boss.getWidth());
                    int offsetY = (int) (Math.random() * boss.getHeight());

                    explosionManager.addBossExplosion(boss.getX() + offsetX, boss.getY() + offsetY, 70, 70);
                }

                SoundPlayer.playSound("assets/SoundTrack/boss_explosive.wav");
                explosionManager.addBossExplosion(boss.getX() + boss.getWidth() / 2 - 100, boss.getY() + boss.getHeight() / 2 - 100, 200, 200);
            }


            bossBattle = false;
            boss = null;
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
