package Tugas.II_5;

public class NullReference {
    private static Rectangle rectangle;

    public static void main(String[] args) {
        if (rectangle == null) {
            System.out.println("rectangle variable doesn’t refer to a Rectangle object");
        } else {
            int area = rectangle.area(5, 7);
            System.out.println("Area: " + area);
        }
    }
}
