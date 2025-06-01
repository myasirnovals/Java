package util;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundPlayer {
    private static Clip backgroundMusic;
    private static String currentMusicPath = null;

    public static void playSound(String filePath) {
        try {
            File soundFile = new File(filePath);
            if (!soundFile.exists()) {
                System.err.print("Sound file not found" + filePath);
                return;
            }
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static void playBackgroundMusic(String filePath) {
        if (backgroundMusic != null && backgroundMusic.isRunning() && filePath.equals(currentMusicPath)) {
            return;
        }
        stopBackgroundMusic();

        try {
            File musicFile = new File(filePath);
            if (!musicFile.exists()) {
                System.err.print("Music file not found" + filePath);
                return;
            }

            AudioInputStream audioIn = AudioSystem.getAudioInputStream(musicFile);
            backgroundMusic = AudioSystem.getClip();
            backgroundMusic.open(audioIn);

            backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY);
            backgroundMusic.start();

            currentMusicPath = filePath;
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static void playBackgroundMusicOnce(String filePath) {
        stopBackgroundMusic();
        try {
            File musicFile = new File(filePath);
            if (!musicFile.exists()) {
                System.err.print("Music file not found" + filePath);
                return;
            }

            AudioInputStream audioIn = AudioSystem.getAudioInputStream(musicFile);
            backgroundMusic = AudioSystem.getClip();
            backgroundMusic.open(audioIn);
            backgroundMusic.start();

            currentMusicPath = filePath;
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static void stopBackgroundMusic() {
        if (backgroundMusic != null && backgroundMusic.isRunning()) {
            backgroundMusic.stop();
            backgroundMusic.close();
        }
        backgroundMusic = null;
        currentMusicPath = null;
    }

    public static void setBackgroundMusicVolume(float volume) {
        if (backgroundMusic != null) {
            try {
                FloatControl gainControl = (FloatControl) backgroundMusic.getControl(FloatControl.Type.MASTER_GAIN);
                float dB = (float) (Math.log(volume) / Math.log(10.0) * 20.0);
                gainControl.setValue(dB);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void pauseBackgroundMusic() {
        if (backgroundMusic != null && backgroundMusic.isRunning()) {
            backgroundMusic.stop();
        }
    }

    public static void resumeBackgroundMusic() {
        if (backgroundMusic != null && !backgroundMusic.isRunning()) {
            backgroundMusic.start();
        }
    }

    public static boolean isBackgroundMusicPlaying() {
        return backgroundMusic != null && backgroundMusic.isRunning();
    }
}
