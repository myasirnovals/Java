public class AlphabetThread {
    public static void main(String[] args) {
        PrintNameThread pnt1 = new PrintNameThread("A");
        PrintNameThread pnt2 = new PrintNameThread("B");
        PrintNameThread pnt3 = new PrintNameThread("C");
        PrintNameThread pnt4 = new PrintNameThread("D");
        PrintNameThread pnt5 = new PrintNameThread("E");
    }
}

class PrintNameThread extends Thread {
    PrintNameThread(String name) {
        super(name);
        start();
    }

    public void run() {
        String name = getName();
        for (int i = 0; i < 100; i++) {
            System.out.print(name);

            if ((i + 1) % 20 == 0) {
                System.out.println();
            }
        }
    }
}
