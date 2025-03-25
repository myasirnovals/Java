package Program.III_3;

public class DecToOthers {
    public static void main(String args[]) {
        int num = Integer.parseInt(args[0]);
        int base = Integer.parseInt(args[1]);
        printBase(num, base);
    }

    static void printBase(int num, int base) {
        int rem = 1;
        String digits = "0123456789abcdef";
        String result = "";

        /* langkah interasi */
        while (num != 0) {
            rem = num % base;
            num = num / base;
            result = result.concat(digits.charAt(rem) + "");
        }

        /* mencetak reverse dari result */
        for (int i = result.length() - 1; i >= 0; i--) {
            System.out.print(result.charAt(i));
        }
    }
}
