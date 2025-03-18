package Tugas.I_2;

public class AritmetikaDemo
{
    public static void main(String[] args)
    {
        // some numbers
        int i = 37;
        int j = 42;

        double x = 27.475;
        double y = 7.22;
        System.out.println("Variable values...");
        System.out.println("    i = " + i);
        System.out.println("    j = " + j);
        System.out.println("    x = " + x);
        System.out.println("    y = " + y);

        // Adding numbers
        System.out.println("Adding...");
        System.out.println("    i + j = " + (i + j)); // harus bernilai 79
        System.out.println("    x + y = " + (x + y));

        // Subtraction
        System.out.println("Subtracting...");
        System.out.println("    i - j = " + (i - j));
        System.out.println("    x - y = " + (x - y));

        // Number multiplier
        System.out.println("Multiplying...");
        System.out.println("    i * j = " + (i * j));
        System.out.println("    x * y = " + (x * y));

        // Divide number
        System.out.println("Dividing...");
        System.out.println("    i / j = " + (i / j));
        System.out.println("    x / y = " + (x / y));

        // Counting the modulus result
        System.out.println("Computing the remainder...");
        System.out.println("    i % j = " + (i % j));
        System.out.println("    x % y = " + (x % y));

        // Mixing type
        System.out.println("Mixing types...");
        System.out.println("    j + y = " + (j + y)); // analisa
        System.out.println("    i * x = " + (i * x)); // analisa
    }
}

