package Tugas.II_3;

import java.util.Scanner;

public class DivideByZeroNoExceptionHandling {
    public static int pembagian(int bil, int pbg) {
        return bil / pbg;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numerator = 0;

        System.out.print("Masukan nilai Pembilang: ");
        numerator = scanner.nextInt();
        System.out.print("Masukan nilai Penyebut (Pembagi): ");
        int denominator = scanner.nextInt();

        int result = pembagian(numerator, denominator);
        System.out.printf("%nResult: %d / %d = %d%n", numerator, denominator, result);
    }
}
