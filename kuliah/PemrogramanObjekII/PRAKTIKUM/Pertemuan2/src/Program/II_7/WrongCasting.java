package Program.II_7;

import Tugas.II_7.Rectangle;

public class WrongCasting {
    public static void main(String[] args) {
        Object rectangle = new Rectangle(10, 10);
        String str = (String) rectangle;
        System.out.println("String str : " + str);
    }
}
