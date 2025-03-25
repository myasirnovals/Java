package Program.III_4;

public class DecToOthers {
    //some code
    //buatlah Program 3-3 menjadi rekursif
    static void printBase(int num, int base) {
        //some code
        /* Langkah Rekursif*/
        if (num >= base) {
            printBase(num / base, base);
        }

        /* Base case: num < base */
        //tentukan apa base case nya?
    }

    public static void main(String args[]) {
        int num = Integer.parseInt(args[0]);
        int base = Integer.parseInt(args[1]);
        printBase(num, base);
    }
}
