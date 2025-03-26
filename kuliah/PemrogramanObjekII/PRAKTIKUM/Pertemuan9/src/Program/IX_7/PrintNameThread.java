package Program.IX_7;

public class PrintNameThread implements Runnable {
    private Thread thread;

    public PrintNameThread(String name) {
        thread = new Thread(this, name);
        thread.start();
    }

    @Override
    public void run() {
        String name = thread.getName();
        for (int i = 0; i < 100; i++) {
            System.out.print(name + " ");
        }
    }

    public static void main(String[] args) {
        new PrintNameThread("Jamaica");
        new PrintNameThread("Fiji");
        new PrintNameThread("Bora bora");
    }
}
