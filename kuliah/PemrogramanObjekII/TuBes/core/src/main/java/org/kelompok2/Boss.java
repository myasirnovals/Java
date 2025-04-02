package org.kelompok2;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

public class Boss {
    private int x, y;
    private int width, height;
    private int health;
    private int speedX, speedY;
    private Image bossSprite;

    public Boss(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 100; // Ukuran Boss lebih besar
        this.height = 100;
        this.health = 10; // Nyawa Boss
        this.speedX = 2; // Kecepatan horizontal
        this.speedY = 2; // Kecepatan vertikal

        try {
            bossSprite = ImageIO.read(new File("assets/Boss/Shooter_Boss_Sprite.png"));
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

    public void update() {
        x += speedX;
        y += speedY;

        // Pantulan dari tepi layar
        if (x <= 0 || x + width >= 800) speedX = -speedX;
        if (y <= 0 || y + height >= 600) speedY = -speedY;
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
