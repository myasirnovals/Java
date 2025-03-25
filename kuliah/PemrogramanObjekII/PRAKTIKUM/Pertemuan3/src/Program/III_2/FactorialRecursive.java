package Program.III_2;

public class FactorialRecursive {
    //buatlah program 3-1 agar ditangani menggunakan rekursi
    //some code
    static int factorial(int n) {
    //some code, tentukan base case untuk menentukan penghentian rekursi

        /* Recursive definition; Self-invocation */
        return factorial(n - 1) * n;
    }

    //some code
}
