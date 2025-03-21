package Tugas.TA.ExtendStudentRecord;

import Tugas.I_15.StudentRecord;

public class CollegeStudent extends StudentRecord {
    private String major;
    private int year;

    public CollegeStudent() {
        super();
    }

    public CollegeStudent(String name) {
        super(name);
    }

    public CollegeStudent(String name, String address) {
        super(name, address);
    }

    public CollegeStudent(String name, String address, int age, int mathGrade, int englishGrade, int scienceGrade) {
        super(name, address, age, mathGrade, englishGrade, scienceGrade);
    }

    public CollegeStudent(String name, String address, int age, int mathGrade, int englishGrade, int scienceGrade, String major, int year) {
        super(name, address, age, mathGrade, englishGrade, scienceGrade);
        this.major = major;
        this.year = year;
    }

    public String getMajor() {
        return major;
    }

    public int getYear() {
        return year;
    }

    public String getDetails() {
        return "Name: " + getName() + "\nAddress: " + getAddress() + "\nAge: " + getAge() + "\nMath Grade: " + getMathGrade() + "\nEnglish Grade: " + getEnglishGrade() + "\nScience Grade: " + getScienceGrade() + "\nMajor: " + getMajor() + "\nYear: " + getYear();
    }
}
