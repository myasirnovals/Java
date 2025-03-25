import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void printArrayList(List<?> list) {
        for (Object element : list) {
            System.out.println(element);
        }
    }

    public static void printNumbers(List<? extends Number> list) {
        for (Number number : list) {
            System.out.println(number);
        }
    }

    public static void addIntegers(List<? super Integer> list) {
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
    }

    public static void main(String[] args) {
        System.out.println("Unbounded Wildcards:");
        List<String> stringList = new ArrayList<>();
        stringList.add("Hello");
        stringList.add("World");
        printArrayList(stringList);

        System.out.println("\nUpper Bounded Wildcards:");
        List<Integer> intList = new ArrayList<>();
        intList.add(10);
        intList.add(20);
        intList.add(30);
        printNumbers(intList);

        List<Double> doubleList = new ArrayList<>();
        doubleList.add(10.5);
        doubleList.add(20.5);
        printNumbers(doubleList);

        System.out.println("\nLower Bounded Wildcards:");
        List<Number> numberList = new ArrayList<>();
        addIntegers(numberList);
        printArrayList(numberList);
    }
}