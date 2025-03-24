package Tugas.TA;

public class Calculator {
    private int memory;

    public void calculate(int i) {
        memory = i;
        memory = memory + 10;
        try {
            memory = memory / 0;
        } catch (ArithmeticException ae) {
            memory = memory + 10;
            memory = memory / 0;
        } finally {
            memory = memory * 2;
            memory = memory / 0;
        }
    }

    public int getMemory() {
        return memory;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        try {
            calculator.calculate(5);
        } catch (Exception e) {
            System.out.println(calculator.getMemory());
        }
    }

    public void doSomeThing() {
        try {
            Object object = new Rectangle();
            String string = (String) object;
        } catch (RuntimeException re) {
            System.out.println("RuntimeException");
        } catch (ClassCastException cce) {
            System.out.println("ClassCastException");
        }
    }

    public class MyException extends ClassCastException {
        public MyException() {
            super("MyException");
        }
    }

    public class MyClass {
        public void doSomething() {
            try {
                Object object = new Rectangle();
                String string = (String) object;
            } catch (MyException me) {
                System.out.println("catching MyException");
            } finally {
                System.out.println("executing finally block");
            }
        }
    }

    public class CatchException {
        public void doSomething() {
            try {
                int i = 1 / 0;
            } catch (Throwable throwable) {
                System.out.println("catching java.lang.Throwable exception ");
            }
        }
    }
}
