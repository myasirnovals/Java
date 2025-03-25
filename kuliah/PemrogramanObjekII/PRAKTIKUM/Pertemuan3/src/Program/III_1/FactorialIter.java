package Program.III_1;

public class FactorialIter {
    static int factorial(int n) {
        int result = 1;
        for (int i = n; i > 1; i--) {
            result *= i;
        }
        return result;
    }

    public static void main(String args[]) {
        int n = Integer.parseInt(args[0]);
        System.out.println(factorial(n));
    }
}
