package Tugas.II_7;

public class WrongCasting {
    public static void main(String[] args) {
        Object rectangle = new Rectangle(10, 10);
        String str = rectangle.toString();
        System.out.println("String str : " + str);
    }
}
