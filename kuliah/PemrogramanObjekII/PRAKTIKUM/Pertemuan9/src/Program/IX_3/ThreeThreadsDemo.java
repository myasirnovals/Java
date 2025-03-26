package Program.IX_3;

class MyThread implements Runnable {
    private String threadName;

    public MyThread(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(threadName + " is running. Count: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(threadName + " interrupted.");
            }
        }
        System.out.println(threadName + " has finished.");
    }
}

public class ThreeThreadsDemo {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyThread("Jamaica"));
        Thread thread2 = new Thread(new MyThread("Fiji"));
        Thread thread3 = new Thread(new MyThread("Bora bora"));

        thread1.start();
        thread2.start();
        thread3.start();

        for (int i = 1; i <= 4; i++) {
            System.out.println("Main thread is running. Count: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted.");
            }
        }
        System.out.println("Main thread has finished.");
    }
}
