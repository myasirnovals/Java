package model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PowerUp {
    private int x, y;
    private final int width = 50, height = 50;
    private final int speed = 3;
    private boolean visible = true;
    private String type;
    private Image image;

    public PowerUp(int x, int y, String type) {
        this.x = x;
        this.y = y;
        this.type = type;


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
                    this.image = null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void move() {
        y += speed;
        if (y > 600) {
            visible = false;
        }
    }

    public void draw(Graphics g) {
        if (!visible) return;


        if (image != null) {
            g.drawImage(image, x, y, width, height, null);
        } else {
            g.setColor(Color.YELLOW);
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
