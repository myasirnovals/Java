package model;

import java.awt.*;

public class BossBullet {
    private int x, y;
    private int width, height;
    private int speedY;
    private boolean active;

    public BossBullet(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 10; // Set the width of the bullet
        this.height = 10; // Set the height of the bullet
        this.speedY = 5; // Set the speed of the bullet
        this.active = true; // Bullet is initially active
    }

    public void update() {
        y += speedY;

        // jika peluru keluar dari layar, nonaktifkan
        if (y > 800) {
            active = false;
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public boolean isActive() {
        return active;
    }
}
