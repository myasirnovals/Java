package org.kelompok2;

import java.awt.*;

public class PowerUp {
    private int x, y;
    private final int width = 30, height = 30; // Ukuran power-up
    private final int speed = 3; // Kecepatan power-up
    private boolean visible = true;
    private String type; // Tipe power-up (misalnya "life", "shield", dll.)

    public PowerUp(int x, int y, String type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void move() {
        y += speed; // Gerakkan power-up ke bawah
        if (y > 600) { // Hilangkan jika keluar layar
            visible = false;
        }
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

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public String getType() {
        return type;
    }
}
