package Program.II_2;

public class MemoryException1 {
    public static void main(String[] args) {
        int[] myArray = new int[5];

        try {
            for (int i = 0; i <= 5; i++) {
                myArray[i] = i;
            }
        } catch (Exception e) {
            System.err.println("Ada pesan kesalahan : " + e);
        }

        System.out.println("Hello world");
    }
}
