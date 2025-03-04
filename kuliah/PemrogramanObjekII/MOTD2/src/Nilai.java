import java.util.InputMismatchException;
import java.util.Scanner;

public class Nilai {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukan nilai [0-100]: ");

        try {
            int nilai = input.nextInt();

            if (!(nilai <= 0) && !(nilai >= 100)) {
                System.out.println("Nilai: " + nilai);
            } else {
                throw new IllegalArgumentException("Range tidak boleh kurang dari 0 dan tidak boleh lebih dari 100");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e);
        } catch (InputMismatchException e) {
            System.out.println("Error: input harus berupa angka --> " + e);
        }
    }
}
