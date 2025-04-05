package model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player {
    // Atribut posisi dan ukuran
    private int x, y;
    private int width, height;
    private BufferedImage playerImage;

    // Atribut untuk kecepatan dan gravitasi
    private int velocityY;
    private final int GRAVITY = 1;
    private final int JUMP_STRENGTH = -15;
    private boolean isJumping;

    // Konstruktor
    public Player(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.velocityY = 0;
        this.isJumping = false;

        // Muat gambar pemain
        try {
            playerImage = ImageIO.read(new File("assets/images/player.png")); // Path ke gambar
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Metode untuk melompat
    public void jump() {
        if (!isJumping) {
            velocityY = JUMP_STRENGTH;
            isJumping = true;
        }
    }

    // Update posisi pemain
    public void update() {
        // Tambahkan gravitasi ke kecepatan
        velocityY += GRAVITY;
        y += velocityY;

        // Cegah pemain jatuh ke bawah layar
        if (y >= 615) { // Misalnya, 950 adalah lantai
            y = 615;
            isJumping = false;
        }
    }

    // Render pemain ke layar
    public void render(Graphics g) {
        if (playerImage != null) {
            // Gambar pemain menggunakan gambar
            g.drawImage(playerImage, x, y, width, height, null);
        } else {
            // Jika gambar tidak ditemukan, gunakan kotak biru sebagai fallback
            g.setColor(Color.BLUE);
            g.fillRect(x, y, width, height);
        }
    }

    // Getter dan Setter (opsional, jika diperlukan)
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
