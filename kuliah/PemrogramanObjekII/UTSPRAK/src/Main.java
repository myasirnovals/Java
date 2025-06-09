import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    private static final String REGISTRATION_PATTERN = "^[A-Za-z]{2}\\d{4}[A-Za-z]{2}$";
    private static final Pattern pattern = Pattern.compile(REGISTRATION_PATTERN);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== FORMULIR REGISTRASI BUKU ===");
        System.out.println();

        System.out.print("Masukkan Judul Buku: ");
        String judulBuku = scanner.nextLine();

        System.out.print("Masukkan Nama Penulis: ");
        String penulis = scanner.nextLine();

        System.out.print("Masukkan Tanggal Terbit (dd/mm/yyyy): ");
        String tanggalTerbit = scanner.nextLine();

        System.out.print("Masukkan ISSN/ISBN: ");
        String issnIsbn = scanner.nextLine();

        String nomorRegistrasi;
        do {
            System.out.print("Masukkan Nomor Registrasi (Format: 2huruf4angka2huruf, contoh: FG1234HJ): ");
            nomorRegistrasi = scanner.nextLine();

            if (!isValidRegistrationNumber(nomorRegistrasi)) {
                System.out.println("Format nomor registrasi tidak valid! Harus 2 huruf + 4 angka + 2 huruf");
            }
        } while (!isValidRegistrationNumber(nomorRegistrasi));

        Book book = new Book(judulBuku, penulis, tanggalTerbit, issnIsbn, nomorRegistrasi);

        saveToFile(book);

        System.out.println("\nData buku berhasil disimpan ke file 'book_registration.txt'");

        scanner.close();
    }

    private static boolean isValidRegistrationNumber(String registrationNumber) {
        return pattern.matcher(registrationNumber).matches();
    }

    private static void saveToFile(Book book) {
        try (FileWriter fileWriter = new FileWriter("book_registration.txt", true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
             PrintWriter printWriter = new PrintWriter(bufferedWriter)) {

            printWriter.println("=== DATA BUKU ===");
            printWriter.println("Judul Buku: " + book.getJudulBuku());
            printWriter.println("Penulis: " + book.getPenulis());
            printWriter.println("Tanggal Terbit: " + book.getTanggalTerbit());
            printWriter.println("ISSN/ISBN: " + book.getIssnIsbn());
            printWriter.println("Nomor Registrasi: " + book.getNomorRegistrasi());
            printWriter.println("Waktu Input: " + java.time.LocalDateTime.now());
            printWriter.println("==================");
            printWriter.println();

        } catch (IOException e) {
            System.err.println("Error saat menyimpan file: " + e.getMessage());
        }
    }
}
