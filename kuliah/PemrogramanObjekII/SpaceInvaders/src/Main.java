import ui.GameWindow;

public class Main {
    public static void main(String[] args) {
        // entry point untuk program
        javax.swing.SwingUtilities.invokeLater(() -> {
            GameWindow gameWindow = new GameWindow();
        });
    }
}