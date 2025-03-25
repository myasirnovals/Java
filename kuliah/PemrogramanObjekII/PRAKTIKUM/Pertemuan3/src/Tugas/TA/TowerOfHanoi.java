package Tugas.TA;

import java.util.Scanner;

public class TowerOfHanoi {
    static void solveHanoi(int n, char source, char temp, char target) {
        if (n == 1) {
            System.out.println("Pindahkan cakram 1 dari tiang " + source + " ke tiang " + target);
            return;
        }

        solveHanoi(n - 1, source, target, temp);
        System.out.println("Pindahkan cakram " + n + " dari tiang " + source + " ke tiang " + target);

        solveHanoi(n - 1, temp, source, target);
    }

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Masukkan jumlah cakram: ");
            int n = input.nextInt();

            if (n <= 0) {
                System.out.println("Jumlah cakram harus lebih dari 0.");
                return;
            }

            System.out.println("Langkah-langkah untuk menyelesaikan Tower of Hanoi:");
            solveHanoi(n, 'A', 'B', 'C');
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}
