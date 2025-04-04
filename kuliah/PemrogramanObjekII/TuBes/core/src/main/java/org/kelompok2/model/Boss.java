package org.kelompok2.model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

public class Boss {
    private int x, y;
    private int width, height;
    private int health;
    private int speedX, speedY;
    private int direction = 1; // 1 untuk kanan, -1 untuk kiri
    private int bossLevel = 1; // Level Boss
    private Image bossSprite;

    public Boss(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 150; // Ukuran Boss lebih besar
        this.height = 150;
        this.health = 20; // Nyawa Boss
        this.speedX = 2; // Kecepatan horizontal
        this.speedY = 2; // Kecepatan vertikal

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
    }

    public void update(int canvasWidth) {
        x += speedX * direction;

        // jika boss mencapai tepi layar, ubah arah
        if (x <= 0 || x + width >= canvasWidth) {
            direction *= -1;
        }
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
}
