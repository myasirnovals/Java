package Tugas.I_10.b;

import Program.I_10.a.Kucing;

import java.awt.*;

public class LingkunganRumah {
    public static void main(String[] args) {
        Kucing michael = new Kucing();
        Kucing garfield = new Kucing();

        michael.warnaBulu = new Color(0, 1, 1);
        michael.nama = "Michael";
        michael.usia = 3;
        michael.bb = 4.5;
        michael.diadopsi("Rezki");

        garfield.warnaBulu = new Color(0, 1, 1);
        garfield.nama = "Michael";
        garfield.usia = 3;
        garfield.bb = 4.5;
        garfield.diadopsi("Rezki");
    }
}
