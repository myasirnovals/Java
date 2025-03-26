package Program.VIII_2;

import java.util.Scanner;

public class Addition2 {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Masukkan nilai integer pertama = ");
            int num1 = input.nextInt();

            System.out.print("Masukkan nilai integer kedua = ");
            int num2 = input.nextInt();

            int sum = num1 + num2;
            System.out.println("Hasil penjumlahannya adalah " + sum);
        } catch (Exception e) {
            System.out.println("Input tidak valid. Harap masukkan angka integer.");
        }
    }
}