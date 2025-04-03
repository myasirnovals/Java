package org.kelompok2.util;

public class GameState {
    private int score;
    private int lives;
    private int level;
    private int highScore;
    private int conqueredArea;
    private final int maxConqueredArea = 100;
    private boolean gameOver;

    public GameState() {
        this.score = 0;
        this.lives = 3;
        this.level = 1;
        this.highScore = 0;
        this.conqueredArea = 0;
    }

    // method untuk mengurangi lives
    public void decreaseLives() {
        if (lives > 0) {
            lives--;
        }

        // jika lives habis, set gameOver menjadi true
        if (lives == 0) {
            setGameOver(true);
        }
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
        this.lives = Math.max(0, lives);
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

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public int getMaxConqueredArea() {
        return maxConqueredArea;
    }

    // Metode untuk update high score jika score saat ini lebih tinggi
    public void updateHighScore() {
        if (score > highScore) {
            highScore = score;
        }
    }
}
