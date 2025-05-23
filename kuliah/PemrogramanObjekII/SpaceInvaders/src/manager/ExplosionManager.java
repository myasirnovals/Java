package manager;

import model.ExplosionEffect;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class ExplosionManager {
    private ArrayList<ExplosionEffect> explosions = new ArrayList<>();

    public void addExplosion(int x, int y) {
        explosions.add(new ExplosionEffect( x, y, "bullet"));
    }

    public void addBossExplosion(int x, int y){
        explosions.add(new ExplosionEffect(x, y, "boss", 100, 100));
    }

    public void addBossExplosion(int x, int y, int width, int height){
        explosions.add(new ExplosionEffect(x, y, "boss", width, height));
    }

    public void update(){
        Iterator<ExplosionEffect> iterator = explosions.iterator();
        while (iterator.hasNext()){
            ExplosionEffect explosion = iterator.next();
            explosion.update();
            if(!explosion.isActive()){
                iterator.remove();
            }
        }
    }

    public void draw(Graphics g) {
        for(ExplosionEffect explosion : explosions){
            explosion.draw(g);
        }
    }

    public void reset(){
        explosions.clear();
    }
}
