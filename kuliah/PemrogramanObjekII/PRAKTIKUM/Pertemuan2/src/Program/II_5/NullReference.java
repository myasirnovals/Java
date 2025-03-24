package Program.II_5;

public class NullReference {
    private static Rectangle rectangle;

    public static void main(String[] args) {
        int area = rectangle.area();
        System.out.println("Area: " + area);
    }
}
