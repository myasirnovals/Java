package Program.IX_11;

public class SharedData {
    int data;

    synchronized void set(int value) {
        System.out.println("Generate " + value);
        data = value;
    }

    synchronized int get() {
        System.out.println("Get " + data);
        return data;
    }
}

class Producer implements Runnable {
    SharedData sd;

    Producer(SharedData sd) {
        this.sd = sd;
        new Thread(this, "Producer").start();
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            sd.set((int) (Math.random() * 100));
        }
    }
}

class Consumer implements Runnable {
    SharedData sd;

    Consumer(SharedData sd) {
        this.sd = sd;
        new Thread(this, "Consumer").start();
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            sd.get();
        }
    }
}

class TestProducerConsumer {
    public static void main(String args[]) throws Exception {
        SharedData sd = new SharedData();
        new Producer(sd);
        new Consumer(sd);
    }
}