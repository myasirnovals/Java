package org.kelompok2;

import javax.swing.JFrame;

public class GameWindow extends JFrame {
    public GameWindow() {
        setTitle("Space Invaders");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Tambahkan kanvas ke jendela
        add(new GameCanvas());

        setVisible(true);
    }

    public static void main(String[] args) {
        new GameWindow();
    }
}

