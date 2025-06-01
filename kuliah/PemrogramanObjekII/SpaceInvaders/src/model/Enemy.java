package model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Enemy {
    private int x, y;
    private int width, height;
    private int speed;
    private String movementPattern;
    private boolean shooting = false;
    private int shootTimer = 300;
    private String state = "movingDown";
    private Image sprite;

    public Enemy(int x, int y, int width, int height, int speed, String movementPattern) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.movementPattern = movementPattern;

        try {
            this.sprite = ImageIO.read(new File("assets/Musuh/enemy1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void move() {
        if (state.equals("movingDown")) {
            y += speed;
            if (y >= 150) {
                state = "shooting";
            }
        } else if (state.equals("shooting")) {
            shootTimer--;
            shooting = true;
            if (shootTimer <= 0) {
                state = "continueDown";
                shooting = false;
            }
        } else if (state.equals("continueDown")) {
            y += speed;
        }
    }

    public boolean isShooting() {
        return shooting;
    }

    public void increaseSpeed(int increment) {
        speed += increment;
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

    public Image getSprite() {
        return sprite;
    }
}
