package Tugas.TA;

import java.time.LocalDate;
import java.util.Scanner;

public class CompareDates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan tanggal pertama (format: YYYY-MM-DD): ");
        String date1Input = scanner.nextLine();
        LocalDate date1 = LocalDate.parse(date1Input);

        System.out.print("Masukkan tanggal kedua (format: YYYY-MM-DD): ");
        String date2Input = scanner.nextLine();
        LocalDate date2 = LocalDate.parse(date2Input);

        int result = date1.compareTo(date2);

        if (result < 0) {
            System.out.println("Tanggal pertama (" + date1 + ") lebih awal dari tanggal kedua (" + date2 + ").");
        } else if (result > 0) {
            System.out.println("Tanggal pertama (" + date1 + ") lebih lambat dari tanggal kedua (" + date2 + ").");
        } else {
            System.out.println("Kedua tanggal sama (" + date1 + ").");
        }

        scanner.close();
    }
}
