package Program.I_19;

public class StudentRecord {
    private String name;
    private String address;
    private int age;
    private double mathGrade;
    private double englishGrade;
    private double scienceGrade;
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

    public StudentRecord(int mathGrade, int englishGrade, int scienceGrade) {
        this.mathGrade = mathGrade;
        this.englishGrade = englishGrade;
        this.scienceGrade = scienceGrade;
        STUDENTCOUNT++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getMathGrade() {
        return mathGrade;
    }

    public void setMathGrade(int mathGrade) {
        this.mathGrade = mathGrade;
    }

    public double getEnglishGrade() {
        return englishGrade;
    }

    public void setEnglishGrade(int englishGrade) {
        this.englishGrade = englishGrade;
    }

    public double getScienceGrade() {
        return scienceGrade;
    }

    public void setScienceGrade(int scienceGrade) {
        this.scienceGrade = scienceGrade;
    }

    public double getAverage() {
        return (mathGrade + englishGrade + scienceGrade) / 3.0;
    }

    public static int getSTUDENTCOUNT() {
        return STUDENTCOUNT;
    }

    public void print(String temp) {
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Age: " + age);
    }

    public void print(double eGrade, double mGrade, double sGrade) {
        System.out.println("Name: " + name);
        System.out.println("English Grade: " + eGrade);
        System.out.println("Math Grade: " + mGrade);
        System.out.println("Science Grade: " + sGrade);
    }
}
