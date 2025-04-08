package model;

import java.awt.*;

public class BossBullet {
    private int x, y;
    private int width, height;
    private int speedX, speedY;
    private boolean active;
    private boolean homing; // Apakah peluru ini pelacak?

    public BossBullet(int x, int y, int speedX, int speedY) {
        this(x, y, speedX, speedY, false); // Default bukan pelacak
    }

    public BossBullet(int x, int y, int speedX, int speedY, boolean homing) {
        this.x = x;
        this.y = y;
        this.width = 10; // Set the width of the bullet
        this.height = 10; // Set the height of the bullet
        this.speedX = speedX; // Kecepatan horizontal
        this.speedY = speedY; // Kecepatan vertikal
        this.active = true; // Bullet is initially active
        this.homing = homing; // Apakah peluru ini pelacak?
    }

    public void update() {
        if (homing) {
            // Logika peluru pelacak (contoh sederhana)
            if (x < 400) { // Misalnya target di tengah layar
                speedX = 2;
            } else {
                speedX = -2;
            }
        }

        x += speedX;
        y += speedY;

        // jika peluru keluar dari layar, nonaktifkan
        if (y > 800 || x < 0 || x > 800) {
            active = false;
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, width, height);
    }

    public boolean isActive() {
        return active;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
