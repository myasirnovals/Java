import java.util.Scanner;

public class TulisNama {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukan Nama: ");

        try {
            String name = input.nextLine();

            if (name.matches("[a-zA-Z ]+")) {
                System.out.println("Nama: " + name);
            } else {
                throw new IllegalArgumentException("Input harus berupa huruf");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
