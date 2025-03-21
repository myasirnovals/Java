package Tugas.I_11;

public class Kangoroo {
    private String name;
    private String color;
    private int birthYear;

    public Kangoroo() {
        this.name = "";
        this.color = "";
        this.birthYear = 0;
    }

    public Kangoroo(String name, String color, int birthYear) {
        this.name = name;
        this.color = color;
        this.birthYear = birthYear;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Color: " + color);
        System.out.println("Birth Year: " + birthYear);
    }
}
