package Tugas.III_3;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class DecToOthers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            System.out.print("Masukan Num: ");
            int num = input.nextInt();

            System.out.print("Masukan Base: ");
            int base = input.nextInt();

            printBase(num, base);
        } catch (NoSuchElementException e) {
            System.out.println("E: " + e.getMessage());
        }
    }

    static void printBase(int num, int base) {
        if (num == 0) {
            return;
        }

        String digits = "0123456789abcdef";

        printBase(num / base, base);
        System.out.print(digits.charAt(num % base));
    }
}
