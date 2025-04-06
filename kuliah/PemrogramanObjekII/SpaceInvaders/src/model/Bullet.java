package model;

import java.awt.*;

public class Bullet {
    private int x, y;
    private final int width, height;
    private final int speed;
    private Color color;

    // Constructor dengan parameter tambahan untuk mendukung berbagai jenis peluru
    public Bullet(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.speed = 15;
    }

    // Constructor default untuk kompatibilitas mundur
    public Bullet(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 5;
        this.height = 10;
        this.color = Color.WHITE;
        this.speed = 15;
    }

    public void move() {
        y -= speed; // Gerakkan peluru ke atas
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Color getColor() {
        return color;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
