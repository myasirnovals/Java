package ui;

import manager.*;
import model.Player;
import util.GameState;
import util.SoundPlayer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class GameCanvas extends JPanel implements Runnable, KeyListener {
    private int shieldDuration = 0;
    private int laserDuration = 0;
    private int scorePerLevel = 150;
    private int lastLevelUpScore = 0;
    private int levelUpMessageTimer = 0;
    private int timePerLevel = 30;
    private int gameTimer = 0;
    private long lastLevelUpTime;
    private boolean shieldActive = false;
    private boolean laserActive = false;
    private boolean leftPressed = false;
    private boolean rightPressed = false;
    private boolean showLevelUpMessage = false;
    private boolean gameOverMusicPlayed = false;
    private GameWindow gameWindow;
    private ExplosionManager explosionManager;
    private Timer winTimer;

    private static Image heartImage;
    private static Image background;

    private final GameState gameState;
    private final Player player;
    private final BulletManager bulletManager;
    private final EnemyManager enemyManager;
    private final PowerUpManager powerUpManager;
    private final BossManager bossManager;

    public GameCanvas(GameWindow gameWindow) {
        this.gameWindow = gameWindow;

        lastLevelUpTime = System.currentTimeMillis();

        gameState = new GameState();
        bulletManager = new BulletManager();
        enemyManager = new EnemyManager();
        powerUpManager = new PowerUpManager();
        bossManager = new BossManager();
        explosionManager = new ExplosionManager();

        bulletManager.setExplosionManager(explosionManager);
        enemyManager.setExplosionManager(explosionManager);
        bossManager.setExplosionManager(explosionManager);

        Image playerSprite = Toolkit.getDefaultToolkit().getImage("assets/Character/Ships/ship_0000.png");
        player = new Player(375, 500, 50, 50, 10, playerSprite);

        if (background == null) {
            try {
                background = ImageIO.read(new File("assets/Background/1747005523800.jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (heartImage == null) {
            try {
                heartImage = ImageIO.read(new File("assets/Skill/life_up.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Thread gameThread = new Thread(this);
        gameThread.start();

        setFocusable(true);
        requestFocus();
        addKeyListener(this);

        playGameBackgroundMusic();
    }

    public void activateShield() {
        shieldActive = true;
        shieldDuration = 300;
    }

    public void activateLaser() {
        laserActive = true;
        laserDuration = 300;
        bulletManager.setLaserMode(true);
    }

    private void checkLevelUp() {
        if (bossManager.isBossBattle()) {
            return;
        }

        gameTimer++;

        long currentTime = System.currentTimeMillis();
        long timeElapsed = currentTime - lastLevelUpTime;

        if (timeElapsed >= timePerLevel * 1000 && !bossManager.isBossBattle()) {
            if (gameState.getLevel() % 2 == 0) {
                bossManager.spawnBoss(getWidth(), gameState.getLevel());
                lastLevelUpTime = currentTime;
            } else {
                if (gameState.getLevel() < 10) {
                    gameState.increaseLevel();
                    lastLevelUpTime = currentTime;

                    showLevelUpMessage = true;
                    levelUpMessageTimer = 120;

                    enemyManager.increaseEnemySpeed(gameState.getLevel());
                    enemyManager.increaseSpawnRate(gameState.getLevel());
                } else {
                    gameState.setGameOver(true);
                    gameState.setGameOverReason("You Won!");
                }
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            updateGame();
            repaint();
            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateGame() {
        if (gameState.isGameOver()) {
            if (!gameOverMusicPlayed) {
                SoundPlayer.stopBackgroundMusic();
                SoundPlayer.playBackgroundMusicOnce("assets/SoundTrack/game_over.wav");
                gameOverMusicPlayed = true;
            }

            if ("You Won!".equals(gameState.getGameOverReason()) && winTimer == null) {
                winTimer = new Timer(2000, e -> {
                    gameWindow.showMainMenu();
                    winTimer.stop();
                    winTimer = null;
                });
                winTimer.setRepeats(false);
                winTimer.start();
            }
            return;
        }

        explosionManager.update();

        if (leftPressed) {
            player.moveLeft();
        }
        if (rightPressed) {
            player.moveRight(getWidth());
        }

        bulletManager.updateBullets(getHeight(), enemyManager.getEnemies(), gameState);
        enemyManager.spawnEnemy(getWidth());
        enemyManager.updateEnemies(getHeight(), player.getBounds(), shieldActive, gameState);
        powerUpManager.spawnPowerUp(getWidth());
        powerUpManager.updatePowerUps(player.getBounds(), gameState, this);

        if (gameState.getConqueredArea() >= gameState.getMaxConqueredArea()) {
            gameState.setGameOver(true);
            gameState.setGameOverReason("Area Fully Conquered");
            return;
        }

        checkLevelUp();

        if (showLevelUpMessage) {
            levelUpMessageTimer--;
            if (levelUpMessageTimer <= 0) {
                showLevelUpMessage = false;
            }
        }

        if (bossManager.isBossBattle()) {
            bossManager.updateBoss(bulletManager.getBullets(), gameState, player, getWidth());
        }

        if (bossManager.checkBossDefeat(gameState)) {
            lastLevelUpTime = System.currentTimeMillis();

            showLevelUpMessage = true;
            levelUpMessageTimer = 120;

            enemyManager.increaseEnemySpeed(gameState.getLevel());
            enemyManager.increaseSpawnRate(gameState.getLevel());
        }

        if (shieldActive) {
            shieldDuration--;
            if (shieldDuration <= 0) {
                shieldActive = false;
            }
        }

        if (laserActive) {
            laserDuration--;
            if (laserDuration <= 0) {
                laserActive = false;
                bulletManager.setLaserMode(false);
            }
        }

        if (gameOverMusicPlayed && !gameState.isGameOver()) {
            gameOverMusicPlayed = false;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(background, 0, 0, getWidth(), getHeight(), this);

        explosionManager.draw(g);

        player.draw(g2d);
        bulletManager.drawBullets(g2d);
        enemyManager.drawEnemies(g2d);
        powerUpManager.drawPowerUps(g2d);

        if (bossManager.isBossBattle()) {
            bossManager.drawBoss(g2d);
        }

        Font regularFont = new Font("Arial", Font.BOLD, 16);
        g2d.setFont(regularFont);

        g2d.setColor(Color.WHITE);
        g2d.drawString("Score: " + gameState.getScore(), 20, 25);

        g2d.setColor(Color.WHITE);
        long timeRemaining;
        if (bossManager.isBossBattle()) {
            timeRemaining = 0;
        } else {
            timeRemaining = ((timePerLevel * 1000L) - (System.currentTimeMillis() - lastLevelUpTime)) / 1000;
        }
        timeRemaining = Math.max(timeRemaining, 0);
        g2d.drawString("Time to next level: " + timeRemaining + "s", 20, 50);

        g2d.setColor(Color.YELLOW);
        String levelText = "Level: " + gameState.getLevel();
        FontMetrics fm = g2d.getFontMetrics();
        int levelWidth = fm.stringWidth(levelText);
        g2d.drawString(levelText, getWidth() / 2 - levelWidth / 2, 25);

        String highScoreText = "High Score: " + gameState.getHighScore();
        int highScoreWidth = fm.stringWidth(highScoreText);
        g2d.drawString(highScoreText, getWidth() / 2 - highScoreWidth / 2, 50);

        g2d.setColor(Color.WHITE);
        String areaText = "Conquered Area: " + gameState.getConqueredArea() + "/" + gameState.getMaxConqueredArea();
        int areaWidth = fm.stringWidth(areaText);
        g2d.drawString(areaText, getWidth() - areaWidth - 20, 25);

        int lives = gameState.getLives();
        int heartX = 20;
        int heartY = getHeight() - 40;

        for (int i = 0; i < lives; i++) {
            g2d.drawImage(heartImage, heartX, heartY, 30, 30, null);
            heartX += 35;
        }

        if (shieldActive) {
            g2d.setColor(Color.BLUE);
            g2d.drawString("Shield Active: " + shieldDuration / 60 + "s", 20, getHeight() - 40);

            g2d.setColor(new Color(0, 0, 255, 100));
            g2d.fillOval(player.getX() - 5, player.getY() - 5, player.getWidth() + 10, player.getHeight() + 10);
        }

        if (laserActive) {
            g2d.setColor(Color.RED);
            g2d.drawString("Laser Active: " + laserDuration / 60 + "s", 20, getHeight() - 60);
        }

        if (showLevelUpMessage) {
            Font levelUpFont = new Font("Arial", Font.BOLD, 30);
            g2d.setFont(levelUpFont);
            g2d.setColor(Color.GREEN);
            String levelUpText = "LEVEL UP! " + gameState.getLevel();
            fm = g2d.getFontMetrics();
            int levelUpWidth = fm.stringWidth(levelUpText);
            g2d.drawString(levelUpText, getWidth() / 2 - levelUpWidth / 2, getHeight() / 2 - 100);
        }

        if (gameState.isGameOver()) {
            Font gameOverFont = new Font("Arial", Font.BOLD, 40);
            g2d.setFont(gameOverFont);
            g2d.setColor(Color.RED);
            String gameOverText = "GAME OVER";
            fm = g2d.getFontMetrics();
            int gameOverWidth = fm.stringWidth(gameOverText);
            g2d.drawString(gameOverText, getWidth() / 2 - gameOverWidth / 2, getHeight() / 2 - 40);

            Font reasonFont = new Font("Arial", Font.BOLD, 24);
            g2d.setFont(reasonFont);
            g2d.setColor(Color.YELLOW);
            String reasonText = gameState.getGameOverReason();
            fm = g2d.getFontMetrics();
            int reasonWidth = fm.stringWidth(reasonText);
            g2d.drawString(reasonText, getWidth() / 2 - reasonWidth / 2, getHeight() / 2);

            Font scoreFont = new Font("Arial", Font.BOLD, 30);
            g2d.setFont(scoreFont);
            g2d.setColor(Color.WHITE);
            String finalScoreText = "Final Score: " + gameState.getScore();
            fm = g2d.getFontMetrics();
            int scoreWidth = fm.stringWidth(finalScoreText);
            g2d.drawString(finalScoreText, getWidth() / 2 - scoreWidth / 2, getHeight() / 2 + 40);

            String highScoreText2 = "High Score: " + gameState.getHighScore();
            fm = g2d.getFontMetrics();
            int highScoreWidth2 = fm.stringWidth(highScoreText2);
            g2d.drawString(highScoreText2, getWidth() / 2 - highScoreWidth2 / 2, getHeight() / 2 + 80);

            Font instructionFont = new Font("Arial", Font.PLAIN, 20);
            g2d.setFont(instructionFont);
            g2d.setColor(Color.GREEN);
            String instructionText = "Press 'R' to Restart or 'ESC' to Exit";
            fm = g2d.getFontMetrics();
            int instructionWidth = fm.stringWidth(instructionText);
            g2d.drawString(instructionText, getWidth() / 2 - instructionWidth / 2, getHeight() / 2 + 130);
        }
    }

    public void resetGame() {
        gameState.setScore(0);
        gameState.setLives(3);
        gameState.setLevel(1);
        gameState.setConqueredArea(0);
        gameState.setGameOver(false);
        gameState.setGameOverReason("");

        explosionManager.reset();

        lastLevelUpScore = 0;
        showLevelUpMessage = false;
        levelUpMessageTimer = 0;

        player.setX(375);
        player.setY(500);

        bulletManager.getBullets().clear();
        enemyManager.getEnemies().clear();
        powerUpManager.getPowerUps().clear();
        bossManager.resetBoss();

        shieldActive = false;
        shieldDuration = 0;
        laserActive = false;
        laserDuration = 0;
        bulletManager.setLaserMode(false);

        lastLevelUpTime = System.currentTimeMillis();
        gameTimer = 0;

        gameState.resetTime();

        gameOverMusicPlayed = false;
        SoundPlayer.stopBackgroundMusic();
        playGameBackgroundMusic();

        if (winTimer != null) {
            winTimer.stop();
            winTimer = null;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (gameState.isGameOver()) {
            if (key == KeyEvent.VK_R) {
                resetGame();
            } else if (key == KeyEvent.VK_ESCAPE) {
                gameWindow.showMainMenu();
            }
            return;
        }

        if (key == KeyEvent.VK_LEFT) {
            leftPressed = true;
        } else if (key == KeyEvent.VK_RIGHT) {
            rightPressed = true;
        } else if (key == KeyEvent.VK_SPACE) {
            bulletManager.addBullet(player.getX() + player.getWidth() / 2 - 2, player.getY());
            if (laserActive) {
                SoundPlayer.playSound("assets/SoundTrack/laser_tiga.wav");
            } else {
                SoundPlayer.playSound("assets/SoundTrack/laser_player.wav");
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            leftPressed = false;
        } else if (key == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    private void playGameBackgroundMusic() {
        SoundPlayer.playBackgroundMusic("assets/SoundTrack/in_game.wav");
    }

    public void stopGameBackgroundMusic() {
        SoundPlayer.stopBackgroundMusic();
    }
}
