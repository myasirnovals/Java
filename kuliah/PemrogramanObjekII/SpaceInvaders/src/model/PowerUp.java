package model;

import java.awt.*;

public class PowerUp {
    private int x, y;
    private final int width = 30, height = 30; // Ukuran power-up
    private final int speed = 3; // Kecepatan power-up
    private boolean visible = true;
    private String type; // Tipe power-up (misalnya "life", "shield", "laser")
    private Color color; // Warna untuk power-up

    public PowerUp(int x, int y, String type) {
        this.x = x;
        this.y = y;
        this.type = type;

        // Set warna berdasarkan tipe power-up
        switch (type) {
            case "life":
                this.color = Color.GREEN; // Hijau untuk tambahan nyawa
                break;
            case "shield":
                this.color = Color.BLUE; // Biru untuk shield
                break;
            case "laser":
                this.color = Color.RED; // Merah untuk laser
                break;
            default:
                this.color = Color.YELLOW; // Default kuning
        }
    }

    public void move() {
        y += speed; // Gerakkan power-up ke bawah
        if (y > 600) { // Hilangkan jika keluar layar
            visible = false;
        }
    }

    public void draw(Graphics g) {
        if (!visible) return;

        g.setColor(color);
        g.fillOval(x, y, width, height); // Gambar bentuk bulat untuk power-up

        // Tambahkan outline agar lebih terlihat
        g.setColor(Color.WHITE);
        g.drawOval(x, y, width, height);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
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

    public String getType() {
        return type;
    }
}
