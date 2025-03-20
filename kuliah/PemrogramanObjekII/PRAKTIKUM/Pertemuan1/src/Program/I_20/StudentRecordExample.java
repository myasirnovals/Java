package Program.I_20;

import Program.I_19.StudentRecord;

public class StudentRecordExample {
    public static void main(String[] args) {
        // membuat 3 object StudentRecord
        StudentRecord agusSurugus = new StudentRecord();
        StudentRecord Aldares = new StudentRecord();
        StudentRecord kiarts = new StudentRecord();

        // versi baru yang ditambahkan
        StudentRecord funto = new StudentRecord("Fiat Funto");
        StudentRecord songjongkok = new StudentRecord("Song Jongkok", "Jl. Kaliurang");
        StudentRecord sungcunguk = new StudentRecord(20, 25, 10);

        // memberi nama siswa
        agusSurugus.setName("Agus Surugus");
        Aldares.setName("Aldares");
        kiarts.setName("Kiarts");

        // menampilkan nama siswa "agus"
        System.out.println("Nama Siswa: " + agusSurugus.getName());

        // menampilkan jumlah siswa
        System.out.println("Jumlah Siswa: " + StudentRecord.getSTUDENTCOUNT());

        StudentRecord agusLiebert = new StudentRecord();
        agusLiebert.setName("Agus Liebert");
        agusLiebert.setAddress("Jl. Kaliurang");
        agusLiebert.setAge(20);
        agusLiebert.setMathGrade(10);
        agusLiebert.setEnglishGrade(15);
        agusLiebert.setScienceGrade(5);

        // overload method
        agusLiebert.print(agusLiebert.getName());
        agusLiebert.print(agusLiebert.getEnglishGrade(), agusLiebert.getMathGrade(), agusLiebert.getScienceGrade());
        agusSurugus.print(agusSurugus.getName());
    }
}
