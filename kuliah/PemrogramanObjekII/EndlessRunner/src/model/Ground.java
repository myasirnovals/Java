package model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Ground {
    private int x, y;
    private int width, height;
    private Image groundImage;

    public Ground(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        // Muat gambar tanah
        try {
            groundImage = ImageIO.read(new File("assets/images/medium_ground.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void render(Graphics g) {
        if (groundImage != null) {
            int imageWidth = groundImage.getWidth(null); // Lebar gambar tanah

            // Gambar tanah dari posisi x hingga memenuhi layar
            for (int i = x; i < getScreenWidth(); i += imageWidth) {
                g.drawImage(groundImage, i, y, imageWidth, height, null);
            }

            // Gambar tanah tambahan jika posisi x negatif
            for (int i = x - imageWidth; i < 0; i += imageWidth) {
                g.drawImage(groundImage, i, y, imageWidth, height, null);
            }
        }
    }

    public void update() {
        // Tanah bergerak ke kiri
        x -= 5;

        int imageWidth = groundImage.getWidth(null); // Lebar gambar tanah

        // Reset posisi tanah jika sudah keluar dari layar
        if (x <= -imageWidth) {
            x += imageWidth;
        }
    }

    private int getScreenWidth() {
        return Toolkit.getDefaultToolkit().getScreenSize().width;
    }
}
