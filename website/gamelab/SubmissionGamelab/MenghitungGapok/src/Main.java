import java.util.Scanner;
import java.util.stream.IntStream;

public class Main
{
    static long tjGol, tjMk;

    static int[] tjAnakAnak;
    static int[] usiaAnak;

    public static void jumlahAnak(int value) {
        Scanner input = new Scanner(System.in);
        usiaAnak = new int[value];

        if (value < 3) {
            for (int i = 0; i < value; i++) {
                System.out.println("Masukan umur anak ke-" + (i + 1));
                usiaAnak[i] = input.nextInt();
            }
        } else {
            for (int i = 0; i < 3; i++) {
                usiaAnak[i] = 17;
            }
        }
    }

    public static void usia(int[] umur) {
        tjAnakAnak = new int[umur.length];

        for (int i = 0; i < umur.length; i++) {
            if (umur[i] <= 17) {
                tjAnakAnak[i] = 700000;
            } else {
                tjAnakAnak[i] = 0;
            }
        }
    }

    public static long golongan(int value) {
        if (value == 1) {
            return tjGol = 1000000;
        } else if (value == 2) {
            return tjGol = 200000;
        } else {
            return tjGol = 0;
        }
    }

    public static long lamaBekerja(int value) {
        if (value < 5) {
            return tjMk = 500000;
        } else if (value > 5 && value < 10) {
            return tjMk = 100000;
        } else {
            return tjMk = 200000;
        }
    }



    public static void main(String[] args) {
        // kamus
        long gaji, tjAnak, total;
        int anak, gol, mk;

        // algoritma
        Scanner userInput = new Scanner(System.in);

        System.out.println("Masukan gaji: ");
        gaji = userInput.nextInt();

        System.out.println("Masukan jumlah anak: ");
        anak = userInput.nextInt();

        // menentukan umur anak yang diinputkan
        jumlahAnak(anak);

        // menentukan anak yang mendapatkan tunjangan
        usia(usiaAnak);

        // menentukan golongan
        System.out.println("Masukan golongan: ");
        gol = userInput.nextInt();

        // menentukan lama/masa kerja
        System.out.println("Masukan masa kerja: ");
        mk = userInput.nextInt();

        // menhitung seleruh tunjangan anak
        tjAnak = IntStream.of(tjAnakAnak).sum();

        total = gaji + tjAnak + golongan(gol) + lamaBekerja(mk);

        System.out.println("Total gaji / gaji pokok yang anda dapatkan");
        System.out.println(total);
    }
}
