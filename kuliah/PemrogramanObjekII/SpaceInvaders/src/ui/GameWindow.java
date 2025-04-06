package ui;

import javax.swing.*;

public class GameWindow extends JFrame {

    private GameCanvas gameCanvas;
    private MainMenu mainMenu;

    public GameWindow() {
        setTitle("Space Shooter");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        mainMenu = new MainMenu(this);
        add(mainMenu);

        setVisible(true);
    }

    public void showGame() {
        remove(mainMenu);
        gameCanvas = new GameCanvas(this); // tambahkan this
        add(gameCanvas);
        revalidate();
        gameCanvas.requestFocusInWindow();
    }

    public void showMainMenu() {
        remove(gameCanvas);
        mainMenu = new MainMenu(this);
        add(mainMenu);
        revalidate();
        mainMenu.requestFocusInWindow();
    }
}
