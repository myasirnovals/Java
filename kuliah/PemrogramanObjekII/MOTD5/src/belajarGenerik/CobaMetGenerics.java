package belajarGenerik;

public class CobaMetGenerics {
    public static void main(String[] args) {
        Double[] arrDouble = {4.1, 2.1, 7.4, 1.8, 2.0};
        Integer[] arrInt = {4, 1, 2, 1, 7, 4, 1, 8, 2};
        String[] arrStr = {"Rezki", "Yuniarti", "IF", "UNJANI"};

        GenericMethodClass.printArray(arrDouble);
        GenericMethodClass.printArray(arrInt);

        GenericMethodClass.printArray(arrStr);
    }
}