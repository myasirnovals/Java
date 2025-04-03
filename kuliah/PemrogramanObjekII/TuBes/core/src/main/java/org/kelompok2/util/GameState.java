package org.kelompok2.util;

public class GameState {
    private int score;
    private int lives;
    private int level;
    private int highScore;
    private int conqueredArea;
    private final int maxConqueredArea = 100;

    public GameState() {
        this.score = 0;
        this.lives = 3;
        this.level = 1;
        this.highScore = 0;
        this.conqueredArea = 0;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public int getConqueredArea() {
        return conqueredArea;
    }

    public void setConqueredArea(int conqueredArea) {
        this.conqueredArea = conqueredArea;
    }
}
