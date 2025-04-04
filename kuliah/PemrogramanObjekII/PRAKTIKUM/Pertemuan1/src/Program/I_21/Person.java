package Program.I_21;

public class Person {
    protected String name;
    protected String address;

    public Person() {
        System.out.println("Inside Person:Constructor");
        this.name = "";
        this.address = "";
    }

    public Person(String name, String address) {
        System.out.println("Inside Person:Constructor(name, address)");
        this.name = name;
        this.address = address;
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
}
