package model;

import javax.swing.*;
import java.awt.*;

public class ExplosionEffect {
    private int x,y;
    private ImageIcon explosionGif;
    private boolean isActive = true;
    private int duration = 30;
    private int currentFrame = 0;

    public ExplosionEffect(int x, int y){
        this.x = x;
        this.y = y;
        this.explosionGif = new ImageIcon("assets/Effect/bulletExplosive.gif");
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
