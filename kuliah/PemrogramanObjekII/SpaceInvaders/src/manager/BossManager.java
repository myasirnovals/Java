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
    // TODO 1: menambahkan atribut explosionManager
    private ExplosionManager explosionManager;

    // TODO 2: Setter untuk ExplosionManager
    public void setExplosionManager(ExplosionManager explosionManager) {
        this.explosionManager = explosionManager;
    }

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
                // TODO 3: menambahkan efek ledakan saat peluru mengenai boss
                if(explosionManager != null){
                    explosionManager.addExplosion(bullet.getX(), bullet.getY());
                }

                boss.hit();
                return true;
            }
            return false;
        });

        // Cek peluru boss mengenai pemain
        List<BossBullet> bossBullets = boss.getBullets();
        bossBullets.removeIf(bossBullet -> {
            if (bossBullet.getBounds().intersects(player.getBounds())) {
                // TODO 4: menambahkan efek ledakan saat peluru boss mengenai pemain
                if(explosionManager != null){
                    explosionManager.addExplosion(player.getX() + player.getWidth()/2, player.getY() + player.getHeight()/2);
                }

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
            // TODO 5: menambahkan efek ledakan saat boss dikalahkan
            if(explosionManager != null){
                //Tambahkan beberapa ledakan untuk efek yang lebih dramatis
                for (int i = 0; i < 5; i++) {
                    int offsetX = (int) (Math.random() * boss.getWidth());
                    int offsetY = (int) (Math.random() * boss.getHeight());

                    explosionManager.addExplosion(boss.getX() + offsetX, boss.getY() + offsetY);
                }

                //Tambahkan ledakan besar di tengah boss
                explosionManager.addExplosion(boss.getX() + boss.getWidth()/2, boss.getY() + boss.getHeight()/2);
            }


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
