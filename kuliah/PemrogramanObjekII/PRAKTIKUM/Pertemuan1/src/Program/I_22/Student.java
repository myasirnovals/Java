package Program.I_22;

import Program.I_21.Person;

public class Student extends Person {
    public Student() {
        // super("Some Name", "Some Address");
        // super();
        // super.name = "Some Name";
        System.out.println("Inside Student:Constructor");
    }

    public static void main(String[] args) {
        Student john = new Student();
    }
}
