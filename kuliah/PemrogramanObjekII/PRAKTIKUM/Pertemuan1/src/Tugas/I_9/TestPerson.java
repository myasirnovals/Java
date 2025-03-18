package Tugas.I_9;

import Program.I_9.OOP.Person;

public class TestPerson {
    public static void main(String[] args) {
        Person dokter = new Person();
        dokter.name = "Agus Surugus";
        dokter.gender = 'L';
        dokter.age = 47;
        dokter.dateOfBirth = "Kaum timur, 25 Februari 2022";
        dokter.height = 175.0f;
        dokter.weight = 67.5f;
        dokter.address = "Blok kaum timur - timur laut";

        dokter.cetakBiodata(dokter.name, dokter.gender, dokter.address);
        System.out.println("\n");
        dokter.cetakFisik(dokter.age, dokter.dateOfBirth, dokter.height, dokter.weight);
    }
}
