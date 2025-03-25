package Tugas.III_4;

import java.util.Scanner;

public class DecToOthers {
    static void printBase(int num, int base) {
        String digits = "0123456789abcdef";

        if (num >= base) {
            printBase(num / base, base);
        }

        System.out.print(digits.charAt(num % base));
    }

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Masukkan angka desimal: ");
            int num = input.nextInt();

            System.out.print("Masukkan basis tujuan (2-16): ");
            int base = input.nextInt();

            if (base < 2 || base > 16) {
                System.out.println("Basis harus antara 2 hingga 16.");
                return;
            }

            System.out.print("Hasil konversi: ");
            printBase(num, base);
            System.out.println();
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}
