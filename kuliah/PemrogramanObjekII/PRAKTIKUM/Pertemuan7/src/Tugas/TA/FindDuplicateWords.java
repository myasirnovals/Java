package Tugas.TA;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindDuplicateWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan teks: ");
        String input = scanner.nextLine();

        String regex = "\\b(\\w+)\\b\\s+\\b\\1\\b";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);

        boolean found = false;
        while (matcher.find()) {
            System.out.println("Kata duplikat ditemukan: " + matcher.group());
            found = true;
        }

        if (!found) {
            System.out.println("Tidak ada kata duplikat yang ditemukan.");
        }

        scanner.close();
    }
}
