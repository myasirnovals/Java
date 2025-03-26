package Tugas.VIII_2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteToFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ketikkan teks (ketik 'exit' untuk keluar):");

        String fileName = "output.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            while (true) {
                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("exit")) {
                    System.out.println("Program selesai. Teks telah disimpan di " + fileName);
                    break;
                }

                String processedInput = input.replace('.', '_').toUpperCase();

                writer.write(processedInput);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menulis ke file: " + e.getMessage());
        }

        scanner.close();
    }
}
