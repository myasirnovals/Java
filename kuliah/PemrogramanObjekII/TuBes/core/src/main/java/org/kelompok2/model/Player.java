package org.kelompok2.model;

import java.awt.*;

public class Player {
    private int x, y, width, height, speed;
    private Image sprite;

    public Player(int x, int y, int width, int height, int speed, Image sprite) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.sprite = sprite;
    }

    public void moveLeft() {
        x = Math.max(x - speed, 0);
    }

    public void moveRight(int canvasWidth) {
        x = Math.min(x + speed, canvasWidth - width);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public void draw(Graphics g) {
        if (sprite != null) {
            g.drawImage(sprite, x, y, width, height, null);
        } else {
            g.setColor(Color.WHITE);
            g.fillRect(x, y, width, height);
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Image getSprite() {
        return sprite;
    }

    public void setSprite(Image sprite) {
        this.sprite = sprite;
    }
}
