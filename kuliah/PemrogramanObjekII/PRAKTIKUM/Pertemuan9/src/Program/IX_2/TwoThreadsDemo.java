package Program.IX_2;

import Program.IX_1.SimpleThread;

public class TwoThreadsDemo {
    public static void main(String[] args) {
        new SimpleThread("Jamaica").start();
        new SimpleThread("Fiji").start();
    }
}
