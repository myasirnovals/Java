package ui;

import util.SoundPlayer;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class MainMenu extends JPanel implements ActionListener {

    private JButton playButton, instructionsButton, exitButton;
    private GameWindow gameWindow;
    private Image background;
    private JLabel titleLabel;
    private Timer animationTimer;
    private float titleGlowIntensity = 0.0f;
    private boolean glowIncreasing = true;
    private boolean musicPlaying = false;

    // warna dan font untuk elemen UI
    private final Color BUTTON_COLOR = new Color(30, 60, 120);
    private final Color BUTTON_HOVER_COLOR = new Color(60, 100, 200);
    private final Color BUTTON_TEXT_COLOR = new Color(220, 240, 255);
    private final Color TITLE_COLOR = new Color(255, 255, 255);
    private final Font TITLE_FONT = new Font("Orbitron", Font.BOLD, 48);
    private final Font BUTTON_FONT = new Font("Orbitron", Font.BOLD, 16);

    public MainMenu(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setLayout(null);

        // memuat latar belakang
        try {
            background = ImageIO.read(new File("assets/Background/1747006402495.jpg"));
            System.out.println("Background loaded successfully");
        } catch (IOException e) {
            System.err.println("Error loading background: " + e.getMessage());
            e.printStackTrace();
        }

        // membuat judul dengan efek bayangan
        titleLabel = new JLabel("SPACE INVADERS");
        titleLabel.setForeground(TITLE_COLOR);
        titleLabel.setFont(TITLE_FONT);
        titleLabel.setBounds(200, 60, 400, 60);

        // menambahkan bayangan ke label judul
        Border empty = BorderFactory.createEmptyBorder();
        titleLabel.setBorder(empty);
        add(titleLabel);

        // membuat tombol dengan efek hover
        playButton = createStyledButton("PLAY", 350, 180);
        instructionsButton = createStyledButton("INSTRUCTIONS", 320, 250);
        exitButton = createStyledButton("EXIT", 350, 320);

        // memulai animasi judul
        startTitleAnimation();

        // membuat panel untuk menampilkan efek bayangan
        setOpaque(true);

        // menambahkan menu untuk bgm
        playMenuBackgroundMusic();
    }

    private JButton createStyledButton(String text, int x, int y) {
        JButton button = new JButton(text);

        // Size and position
        int width = text.equals("INSTRUCTIONS") ? 160 : 100;
        button.setBounds(x, y, width, 45);

        // Styling
        button.setBackground(BUTTON_COLOR);
        button.setForeground(BUTTON_TEXT_COLOR);
        button.setFont(BUTTON_FONT);
        button.setFocusPainted(false);
        button.setBorderPainted(true); // Add border for better visibility
        button.setBorder(BorderFactory.createLineBorder(new Color(100, 150, 255), 1));

        // Add drop shadow text effect
        button.putClientProperty("JButton.buttonType", "square");

        // Add hover effects
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(BUTTON_HOVER_COLOR);
                button.setBorder(BorderFactory.createLineBorder(new Color(150, 200, 255), 2));
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(BUTTON_COLOR);
                button.setBorder(BorderFactory.createLineBorder(new Color(100, 150, 255), 1));
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        // Add action listener
        button.addActionListener(this);

        add(button);
        return button;
    }

    private void startTitleAnimation() {
        animationTimer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (glowIncreasing) {
                    titleGlowIntensity += 0.05f;
                    if (titleGlowIntensity >= 1.0f) {
                        glowIncreasing = false;
                    }
                } else {
                    titleGlowIntensity -= 0.05f;
                    if (titleGlowIntensity <= 0.0f) {
                        glowIncreasing = true;
                    }
                }
                repaint();
            }
        });
        animationTimer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Set anti-aliasing for smoother graphics
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        // menggambar latar belakang
        if (background != null) {
            g2d.drawImage(background, 0, 0, getWidth(), getHeight(), this);

            // menambahkan overlay gelap
            g2d.setColor(new Color(0, 0, 0, 120));
            g2d.fillRect(0, 0, getWidth(), getHeight());
        } else {
            // fallback untuk latar belakang jika gambar gagal dimuat
            GradientPaint gradient = new GradientPaint(
                    0, 0, new Color(20, 20, 60),
                    0, getHeight(), new Color(5, 5, 30)
            );
            g2d.setPaint(gradient);
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }

        // menggambar binta di background
        drawStars(g2d);

        // menggambar judul dengan efek glow
        drawGlowingTitle(g2d);
    }

    private void drawStars(Graphics2D g2d) {
        g2d.setColor(Color.WHITE);

        // menggunakan waktu sistem untuk membuat efek bintang bergerak
        long time = System.currentTimeMillis() / 100;

        for (int i = 0; i < 100; i++) {
            int x = (int)(Math.sin(i * 13 + time * 0.01) * getWidth() + getWidth()) % getWidth();
            int y = (int)(Math.cos(i * 7 + time * 0.01) * getHeight() + getHeight()) % getHeight();
            int size = i % 3 + 1;
            g2d.fillOval(x, y, size, size);
        }
    }

    private void drawGlowingTitle(Graphics2D g2d) {
        // mengambil posisi dan teks dari label judul
        int x = titleLabel.getX();
        int y = titleLabel.getY() + 40; // Adjust for baseline
        String text = "SPACE INVADERS";

        // menggambar bayangan
        g2d.setColor(new Color(0, 0, 0, 200));
        g2d.setFont(new Font(TITLE_FONT.getName(), TITLE_FONT.getStyle(), TITLE_FONT.getSize()));
        g2d.drawString(text, x + 4, y + 4); // ketebalan bayangan

        // menggambar efek glow
        float alpha = 0.15f + (titleGlowIntensity * 0.3f);
        int glowRadius = 6 + (int)(titleGlowIntensity * 3);

        for (int i = glowRadius; i > 0; i--) {
            float alphaFactor = alpha * (1.0f - (float)i / glowRadius);
            g2d.setColor(new Color(100, 180, 255, (int)(255 * alphaFactor)));
            g2d.drawString(text, x - i/3, y);
            g2d.drawString(text, x + i/3, y);
        }

        // menggambar teks dengan efek drop shadow
        g2d.setColor(new Color(255, 255, 255, 220));
        g2d.drawString(text, x-1, y-1);
        g2d.drawString(text, x+1, y-1);
        g2d.drawString(text, x-1, y+1);
        g2d.drawString(text, x+1, y+1);

        // menggambarkan teks utama
        g2d.setColor(new Color(220, 240, 255));
        g2d.drawString(text, x, y);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playButton) {
            stopMenuBackgroundMusic();
            fadeOutTransition(() -> gameWindow.showGame());
        } else if (e.getSource() == instructionsButton) {
            showEnhancedInstructions();
        } else if (e.getSource() == exitButton) {
            confirmExit();
        }
    }

    private void fadeOutTransition(Runnable afterTransition) {
        Timer fadeTimer = new Timer(20, new ActionListener() {
            float alpha = 1.0f;
            @Override
            public void actionPerformed(ActionEvent e) {
                alpha -= 0.05f;
                if (alpha <= 0) {
                    ((Timer)e.getSource()).stop();
                    afterTransition.run();
                }
                setAlpha(alpha);
                repaint();
            }
        });
        fadeTimer.start();
    }

    private void setAlpha(float alpha) {
        AlphaComposite alcom = AlphaComposite.getInstance(
                AlphaComposite.SRC_OVER, Math.max(0, Math.min(1, alpha)));
        titleLabel.setForeground(new Color(
                TITLE_COLOR.getRed(),
                TITLE_COLOR.getGreen(),
                TITLE_COLOR.getBlue(),
                (int)(255 * alpha)));
        playButton.setForeground(new Color(
                BUTTON_TEXT_COLOR.getRed(),
                BUTTON_TEXT_COLOR.getGreen(),
                BUTTON_TEXT_COLOR.getBlue(),
                (int)(255 * alpha)));
        instructionsButton.setForeground(new Color(
                BUTTON_TEXT_COLOR.getRed(),
                BUTTON_TEXT_COLOR.getGreen(),
                BUTTON_TEXT_COLOR.getBlue(),
                (int)(255 * alpha)));
        exitButton.setForeground(new Color(
                BUTTON_TEXT_COLOR.getRed(),
                BUTTON_TEXT_COLOR.getGreen(),
                BUTTON_TEXT_COLOR.getBlue(),
                (int)(255 * alpha)));
    }

    private void showEnhancedInstructions() {
        // Membuat dialog untuk menampilkan instruksi
        JDialog dialog = new JDialog((Frame)SwingUtilities.getWindowAncestor(this), "Instructions", true);
        dialog.setSize(400, 350);
        dialog.setLocationRelativeTo(this);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(20, 30, 50));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel("GAME INSTRUCTIONS", JLabel.CENTER);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(titleLabel, BorderLayout.NORTH);

        JTextArea textArea = new JTextArea(
                "CONTROLS:\n" +
                        "• Arrow Keys: Move your ship\n" +
                        "• Space: Fire weapon\n" +
                        "• P: Pause game\n\n" +
                        "OBJECTIVES:\n" +
                        "• Destroy enemy ships to earn points\n" +
                        "• Avoid enemy projectiles\n" +
                        "• Collect power-ups for special abilities\n" +
                        "• Defeat the boss to complete each level\n\n" +
                        "POWER-UPS:\n" +
                        "• Shield: Temporary invulnerability\n" +
                        "• Rapid Fire: Increased firing rate\n" +
                        "• Multi-Shot: Fire multiple projectiles\n\n" +
                        "Good luck, Captain!"
        );
        textArea.setEditable(false);
        textArea.setForeground(Color.WHITE);
        textArea.setBackground(new Color(30, 40, 60));
        textArea.setFont(new Font("Arial", Font.PLAIN, 14));
        textArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        JButton closeButton = new JButton("Close");
        closeButton.setBackground(BUTTON_COLOR);
        closeButton.setForeground(BUTTON_TEXT_COLOR);
        closeButton.setFocusPainted(false);
        closeButton.addActionListener(e -> dialog.dispose());
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(new Color(20, 30, 50));
        buttonPanel.add(closeButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        dialog.setContentPane(panel);
        dialog.setVisible(true);
    }

    private void confirmExit() {
        // Meng-kustom dialog untuk konfirmasi keluar
        JDialog dialog = new JDialog((Frame)SwingUtilities.getWindowAncestor(this), "Confirm Exit", true);
        dialog.setSize(300, 150);
        dialog.setLocationRelativeTo(this);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBackground(new Color(20, 30, 50));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel message = new JLabel("Are you sure you want to exit?", JLabel.CENTER);
        message.setForeground(Color.WHITE);
        message.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(message, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        buttonPanel.setBackground(new Color(20, 30, 50));

        JButton yesButton = new JButton("Yes");
        yesButton.setBackground(new Color(150, 30, 30));
        yesButton.setForeground(Color.WHITE);
        yesButton.setFocusPainted(false);
        yesButton.addActionListener(e -> System.exit(0));

        JButton noButton = new JButton("No");
        noButton.setBackground(BUTTON_COLOR);
        noButton.setForeground(Color.WHITE);
        noButton.setFocusPainted(false);
        noButton.addActionListener(e -> dialog.dispose());

        buttonPanel.add(yesButton);
        buttonPanel.add(noButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        dialog.setContentPane(panel);
        dialog.setVisible(true);
    }

    private void playMenuBackgroundMusic() {
        if (!musicPlaying) {
            SoundPlayer.playBackgroundMusic("assets/SoundTrack/lobby_game.wav");
        }
    }

    private void stopMenuBackgroundMusic() {
        // Menghentikan BGM menu
        if (musicPlaying) {
            SoundPlayer.stopBackgroundMusic();
            musicPlaying = false;
        }
    }

    // Tambahkan ini ke method yang menangani tombol "Start Game"
    private void startGameButtonActionPerformed(java.awt.event.ActionEvent evt) {
        stopMenuBackgroundMusic(); // Hentikan musik menu
        // Kode lainnya untuk memulai game
        gameWindow.showGame();
    }

    // Method untuk memastikan musik berhenti saat panel tidak ditampilkan
    @Override
    public void removeNotify() {
        stopMenuBackgroundMusic();
        super.removeNotify();
    }
}
