package model;

import util.SoundPlayer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Boss {
    private int x, y;
    private int width, height;
    private int health;
    private int speedX, speedY;
    private int direction = 1;
    private int bossLevel;
    private Image bossSprite;
    private List<BossBullet> bullets;
    private int shootCooldown;

    public Boss(int x, int y, int bossLevel) {
        this.x = x;
        this.y = y;
        this.width = 150;
        this.height = 150;
        this.health = 20;
        this.speedX = 2;
        this.speedY = 2;
        this.bullets = new ArrayList<>();
        this.shootCooldown = 0;
        this.bossLevel = bossLevel;

        try {
            bossSprite = ImageIO.read(new File("assets/Boss/Shooter_Boss_Sprite_Lv" + this.bossLevel + ".png"));
        } catch (Exception e) {
            System.err.println("Gagal memuat gambar Boss: " + e.getMessage());
        }
    }

    public void draw(Graphics g) {
        if (bossSprite != null) {
            g.drawImage(bossSprite, x, y, width, height, null);
        } else {
            g.setColor(Color.RED);
            g.fillRect(x, y, width, height);
        }

        for (BossBullet bullet : bullets) {
            bullet.draw(g);
        }
    }

    public void update(int canvasWidth) {
        x += speedX * direction;

        if (x <= 0 || x + width >= canvasWidth) {
            direction *= -1;
        }


        bullets.forEach(BossBullet::update);
        bullets.removeIf(bullet -> !bullet.isActive());


        if (shootCooldown > 0) {
            shootCooldown--;
        } else {
            shoot();
            shootCooldown = 60;
        }
    }

    private void shoot() {
        switch (bossLevel) {
            case 2:

                bullets.add(new BossBullet(x + width / 2 - 5, y + height, 0, 5));
            case 4:

                bullets.add(new BossBullet(x + width / 2 - 5, y + height, -3, 5));
                bullets.add(new BossBullet(x + width / 2 - 5, y + height, 0, 5));
                bullets.add(new BossBullet(x + width / 2 - 5, y + height, 3, 5));
                break;
            case 6:

                bullets.add(new BossBullet(x + width / 2 - 5, y + height, 0, 7, true));
                break;
            case 8:

                bullets.add(new BossBullet(x + width / 2 - 5, y + height, 0, 10));
                break;
            case 10:

                for (int i = 0; i < 5; i++) {
                    bullets.add(new BossBullet(x + width / 2 - 5, y + height + (i * 10), 0, 5));
                }
                break;
            default:

                bullets.add(new BossBullet(x + width / 2 - 5, y + height, 0, 5));
                break;
        }


        SoundPlayer.playSound("assets/SoundTrack/boss_shot.wav");
    }

    public List<BossBullet> getBullets() {
        return bullets;
    }

    public void hit() {
        health--;
    }

    public boolean isDead() {
        return health <= 0;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
