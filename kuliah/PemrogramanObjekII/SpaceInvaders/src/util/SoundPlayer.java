package util;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundPlayer {
    private static Clip backgroundMusic; // Untuk menyimpan referensi musik latar

    // Method yang sudah ada untuk efek suara sekali putar
    public static void playSound(String filePath) {
        try {
            File soundFile = new File(filePath);
            if (!soundFile.exists()){
                System.err.print("Sound file not found" + filePath);
                return;
            }
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e){
            e.printStackTrace();
        }
    }

    // Method baru untuk memainkan background music dengan looping
    public static void playBackgroundMusic(String filePath) {
        stopBackgroundMusic(); // Hentikan musik yang sedang diputar (jika ada)

        try {
            File musicFile = new File(filePath);
            if (!musicFile.exists()){
                System.err.print("Music file not found: " + filePath);
                return;
            }

            AudioInputStream audioIn = AudioSystem.getAudioInputStream(musicFile);
            backgroundMusic = AudioSystem.getClip();
            backgroundMusic.open(audioIn);
            backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY); // Looping terus menerus
            backgroundMusic.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e){
            e.printStackTrace();
        }
    }

    // Method untuk menghentikan background music
    public static void stopBackgroundMusic() {
        if (backgroundMusic != null && backgroundMusic.isRunning()) {
            backgroundMusic.stop();
            backgroundMusic.close();
        }
    }

    // Method untuk mengatur volume background music (0.0f - 1.0f)
    public static void setBackgroundMusicVolume(float volume) {
        if (backgroundMusic != null) {
            try {
                FloatControl gainControl = (FloatControl) backgroundMusic.getControl(FloatControl.Type.MASTER_GAIN);
                // Konversi skala linear (0.0 to 1.0) ke skala desibel
                float dB = (float) (Math.log(volume) / Math.log(10.0) * 20.0);
                gainControl.setValue(dB);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Method untuk pause background music
    public static void pauseBackgroundMusic() {
        if (backgroundMusic != null && backgroundMusic.isRunning()) {
            backgroundMusic.stop();
        }
    }

    // Method untuk melanjutkan background music
    public static void resumeBackgroundMusic() {
        if (backgroundMusic != null && !backgroundMusic.isRunning()) {
            backgroundMusic.start();
        }
    }

    // Method untuk mengecek apakah background music sedang diputar
    public static boolean isBackgroundMusicPlaying() {
        return backgroundMusic != null && backgroundMusic.isRunning();
    }
}
