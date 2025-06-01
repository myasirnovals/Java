package model;

import java.awt.*;
import java.net.URL;

public class Player {
    private int x, y, width, height, speed, shipIndex;
    private Image sprite;

    public Player(int x, int y, int width, int height, int speed, Image sprite) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.sprite = sprite;
    }

    public Player(int shipIndex) {
        this.shipIndex = shipIndex;
        this.sprite = loadImageForShip(shipIndex);
    }

    private Image loadImageForShip(int shipIndex) {
        String[] imagePaths = {"assets/Character/Ships/ship_0000.png", "assets/Character/Ships/ship_0001.png", "assets/Character/Ships/ship_0002.png", "assets/Character/Ships/ship_0003.png",};
        URL url = getClass().getResource("/" + imagePaths[shipIndex]);
        System.out.println("URL: " + url);
        if (url == null) {
            System.err.println("Gambar tidak ditemukan: " + imagePaths[shipIndex]);
            return null;
        }
        return Toolkit.getDefaultToolkit().getImage(url);
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
