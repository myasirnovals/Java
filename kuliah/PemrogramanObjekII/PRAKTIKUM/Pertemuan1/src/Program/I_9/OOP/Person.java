package Program.I_9.OOP;

import java.lang.*;

public class Person {
    public String name;
    public char gender;
    public int age;
    public String dateOfBirth;
    public float height;
    public float weight;
    public String address;

    public void cetakBiodata(String name, char gender, String address) {
        System.out.println("Nama: " + name + ",\nJenis Kelamin: " + gender + ",\nAlamat: " + address);
    }

    public void cetakFisik(int age, String dateOfBirth, float height, float weight) {
        System.out.println("Umur: " + age);
        System.out.println("Tanggal Lahir: " + dateOfBirth);
        System.out.println("Tinggi: " + height);
        System.out.println("Berat: " + weight);
    }
}

