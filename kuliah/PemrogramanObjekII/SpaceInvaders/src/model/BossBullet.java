package model;

import java.awt.*;

public class BossBullet {
    private int x, y;
    private int width, height;
    private int speedX, speedY;
    private boolean active;
    private boolean homing;

    public BossBullet(int x, int y, int speedX, int speedY) {
        this(x, y, speedX, speedY, false);
    }

    public BossBullet(int x, int y, int speedX, int speedY, boolean homing) {
        this.x = x;
        this.y = y;
        this.width = 10;
        this.height = 10;
        this.speedX = speedX;
        this.speedY = speedY;
        this.active = true;
        this.homing = homing;
    }

    public void update() {
        if (homing) {

            if (x < 400) {
                speedX = 2;
            } else {
                speedX = -2;
            }
        }

        x += speedX;
        y += speedY;


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
