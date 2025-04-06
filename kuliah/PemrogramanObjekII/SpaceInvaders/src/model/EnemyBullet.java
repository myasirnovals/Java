package model;

import java.awt.*;

public class EnemyBullet {
    private int x, y;
    private final int width = 5, height = 10;
    private final int speed = 7;
    private Color color = Color.ORANGE;

    public EnemyBullet(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move() {
        y += speed; // Bergerak ke bawah
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public int getY() {
        return y;
    }
}
