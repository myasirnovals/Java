package util;

public class GameState {
    private int score;
    private int lives;
    private int level;
    private int highScore;
    private int conqueredArea;
    private long gameStartTime;
    private long totalPlayTime;
    private final int maxConqueredArea = 100;
    private boolean gameOver;
    private String gameOverReason;

    public GameState() {
        this.score = 0;
        this.lives = 3;
        this.level = 1;
        this.highScore = 0;
        this.conqueredArea = 0;
        this.gameOverReason = "";
        gameStartTime = System.currentTimeMillis();
        totalPlayTime = 0;
    }

    public void decreaseLives() {
        if (lives > 0) {
            lives--;
        }
        if (lives == 0) {
            setGameOver(true);
            setGameOverReason("No Lives Left");
        }
    }

    public void increaseLevel() {
        if (level < 10) {
            level++;
        } else {
            setGameOver(true);
            setGameOverReason("YOU WON!!");
        }
    }


    public void increaseConqueredArea(int amount) {
        conqueredArea += amount;
        if (conqueredArea >= maxConqueredArea) {
            conqueredArea = maxConqueredArea;
            setGameOver(true);
            setGameOverReason("Area Fully Conquered");
        }
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;

        if (score > highScore) {
            highScore = score;
        }
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = Math.max(0, lives);
        if (this.lives == 0) {
            setGameOver(true);
            setGameOverReason("No Lives Left");
        }
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
        this.conqueredArea = Math.min(conqueredArea, maxConqueredArea);
        if (this.conqueredArea == maxConqueredArea) {
            setGameOver(true);
            setGameOverReason("Area Fully Conquered");
        }
    }

    public int getMaxConqueredArea() {
        return maxConqueredArea;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public String getGameOverReason() {
        return gameOverReason;
    }

    public void setGameOverReason(String reason) {
        this.gameOverReason = reason;
    }

    public long getGameStartTime() {
        return gameStartTime;
    }

    public void updatePlayTime() {
        totalPlayTime = System.currentTimeMillis() - gameStartTime;
    }

    public long getTotalPlayTime() {
        return totalPlayTime;
    }

    public String getFormattedPlayTime() {
        long seconds = totalPlayTime / 1000;
        long minutes = seconds / 60;
        seconds = seconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }

    public void resetTime() {
        gameStartTime = System.currentTimeMillis();
        totalPlayTime = 0;
    }
}
