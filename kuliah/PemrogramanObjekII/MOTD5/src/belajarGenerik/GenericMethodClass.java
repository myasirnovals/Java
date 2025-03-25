package belajarGenerik;

public class GenericMethodClass {
    public static <T> void printArray(T[] array) {
        for (T arrayItem : array) {
            System.out.println(arrayItem);
        }
    }
}
