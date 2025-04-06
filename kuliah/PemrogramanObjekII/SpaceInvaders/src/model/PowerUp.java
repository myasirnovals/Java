package model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PowerUp {
    private int x, y;
    private final int width = 50, height = 50; // Ukuran power-up
    private final int speed = 3; // Kecepatan power-up
    private boolean visible = true;
    private String type; // Tipe power-up (misalnya "life", "shield", "laser")
    private Image image; // Gambar power-up

    public PowerUp(int x, int y, String type) {
        this.x = x;
        this.y = y;
        this.type = type;

        // muat gambar sesuai tipe
        try {
            switch (type) {
                case "life":
                    this.image = ImageIO.read(new File("assets/Skill/life_up.png"));
                    break;
                case "shield":
                    this.image = ImageIO.read(new File("assets/Skill/shield_up.png"));
                    break;
                case "laser":
                    this.image = ImageIO.read(new File("assets/Skill/laser_up.png"));
                    break;
                default:
                    this.image = null; // Gambar default jika tipe tidak dikenali
            }
        } catch (IOException e) {
            e.printStackTrace();
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

        // gambar power-up
        if (image != null) {
            g.drawImage(image, x, y, width, height, null);
        } else {
            g.setColor(Color.YELLOW); // Gambar default jika gambar tidak ada
            g.fillRect(x, y, width, height);
        }
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
