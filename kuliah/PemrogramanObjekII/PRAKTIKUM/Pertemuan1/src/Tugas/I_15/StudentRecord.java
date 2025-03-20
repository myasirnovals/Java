package Tugas.I_15;

public class StudentRecord {
    private String name;
    private String address;
    private int age;
    private int mathGrade;
    private int englishGrade;
    private int scienceGrade;
    public static int STUDENTCOUNT = 0;

    public StudentRecord() {
        STUDENTCOUNT++;
    }

    public StudentRecord(String temp) {
        this.name = temp;
        STUDENTCOUNT++;
    }

    public StudentRecord(String name, String address) {
        this.name = name;
        this.address = address;
        STUDENTCOUNT++;
    }

    public StudentRecord(String name, String address, int age, int mathGrade, int englishGrade, int scienceGrade) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.mathGrade = mathGrade;
        this.englishGrade = englishGrade;
        this.scienceGrade = scienceGrade;
        STUDENTCOUNT++;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public int getMathGrade() {
        return mathGrade;
    }

    public int getEnglishGrade() {
        return englishGrade;
    }

    public int getScienceGrade() {
        return scienceGrade;
    }

    public double getAverage() {
        return (mathGrade + englishGrade + scienceGrade) / 3.0;
    }

    public String getDetails() {
        return "Name: " + name + "\nAddress: " + address + "\nAge: " + age + "\nMath Grade: " + mathGrade + "\nEnglish Grade: " + englishGrade + "\nScience Grade: " + scienceGrade + "\nAverage: " + getAverage();
    }
}
