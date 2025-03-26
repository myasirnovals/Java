package Program.VIII_1.b;

import java.io.IOException;

public class Input2 {
    public static void main(String[] args) {
        try {
            System.out.print("Masukkan Karakter: ");
            char i = (char) System.in.read();

            System.out.println("Anda memasukkan " + i);
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat membaca input: " + e.getMessage());
        }
    }
}