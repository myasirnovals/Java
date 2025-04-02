package org.kelompok2;

import java.awt.*;

public class Enemy {
    private int x, y;
    private int width, height;
    private int speed;
    private String movementPattern; // Pola gerakan musuh

    public Enemy(int x, int y, int width, int height, int speed, String movementPattern) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.movementPattern = movementPattern;
    }

    public void move() {
        switch (movementPattern) {
            case "zigzag":
                x += Math.sin(y / 30.0) * 10; // Gerakan zig-zag
                y += speed;
                break;
            case "circle":
                x += Math.cos(y / 30.0) * 10; // Gerakan melingkar
                y += speed;
                break;
            case "random":
                x += (Math.random() > 0.5 ? 1 : -1) * 5; // Gerakan acak
                y += speed;
                break;
            default:
                y += speed; // Gerakan lurus
                break;
        }
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
}
