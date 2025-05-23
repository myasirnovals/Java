package model;

import javax.swing.*;
import java.awt.*;

public class ExplosionEffect {
    private int x,y;
    private ImageIcon explosionGif;
    private boolean isActive = true;
    private int duration = 30;
    private int currentFrame = 0;
    // TODO 1: menambahkan attribute ledakan
    private String type;
    private int width = 50; //ukuran default
    private int height = 50; //ukuran default

    public ExplosionEffect(int x, int y, String type, int width, int height){
        this.x = x;
        this.y = y;
        this.type = type;
        this.width = width;
        this.height = height;

        //Memilih gif berdasarkan tipe
        if ("boss".equals(type)) {
            this.explosionGif = new ImageIcon("assets/Effect/bossExplosive.gif");
            this.duration = 45; //durasi ledakan boss
        } else {
            this.explosionGif = new ImageIcon("assets/Effect/bulletExplosive.gif");
        }
    }

    public ExplosionEffect(int x, int y, String type) {
        this(x,y, type, 50, 50);
    }

    public ExplosionEffect(int x, int y) {
        this(x,y, "bullet", 50, 50);
    }

    public void update() {
        currentFrame++;
        if(currentFrame >= duration){
            isActive = false;
        }
    }

    public void draw(Graphics g) {
        if(isActive){
            g.drawImage(explosionGif.getImage(), x, y, null);
        }
    }

    public boolean isActive(){
        return isActive;
    }
}
