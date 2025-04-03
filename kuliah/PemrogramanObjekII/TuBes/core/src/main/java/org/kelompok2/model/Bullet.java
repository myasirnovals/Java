package org.kelompok2.model;

import java.awt.*;

public class Bullet {
    private int x, y;
    private final int width = 5, height = 10;

    public Bullet(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move() {
        y -= 15; // Gerakkan peluru ke atas
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

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
