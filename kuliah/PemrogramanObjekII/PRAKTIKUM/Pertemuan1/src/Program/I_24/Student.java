package Program.I_24;

public class Student extends Person {
    public Student() {
        // super("SomeName", "SomeAddress");
        // suoer();
        // super.name = "SomeName";
        System.out.println("Inside Student:Constructor");
    }

    public String getName() {
        System.out.println("Student Name: " + name);
        return name;
    }

    public static void main(String[] args) {
        Student student = new Student();
    }
}
