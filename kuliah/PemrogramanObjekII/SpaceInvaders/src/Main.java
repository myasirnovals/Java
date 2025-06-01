import ui.GameWindow;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            GameWindow gameWindow = new GameWindow();
        });
    }
}