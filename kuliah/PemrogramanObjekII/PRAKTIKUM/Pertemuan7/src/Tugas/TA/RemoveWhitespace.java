package Tugas.TA;

import java.util.Scanner;

public class RemoveWhitespace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan teks: ");
        String input = scanner.nextLine();

        String result = input.replaceAll("(?<=\\S)\\s(?=\\S)", "");

        System.out.println("Hasil setelah whitespace dihapus: " + result);

        scanner.close();
    }
}
