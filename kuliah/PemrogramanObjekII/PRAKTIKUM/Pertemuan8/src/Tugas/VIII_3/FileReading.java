package Tugas.VIII_3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileReading {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Masukkan path file yang ingin dibaca:");

        String filePath = scanner.nextLine();
        String line = "", fileContent = "";

        try (BufferedReader fileInput = new BufferedReader(new FileReader(new File(filePath)))) {
            line = fileInput.readLine();
            fileContent = line + "\n";

            while (line != null) {
                line = fileInput.readLine();
                if (line != null) fileContent += line + "\n";
            }

            System.out.println("Isi file:");
            System.out.println(fileContent);

        } catch (IOException ioe) {
            System.out.println("Terjadi kesalahan saat membaca file: " + ioe.getMessage());
        }

        scanner.close();
    }
}
