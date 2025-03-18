package Program.I_3;

public class UnaryOperator {
    public static void main(String[] args) {
        int i = 10;
        int j = 3;
        int k = 0;

        k = ++j + i;
        System.out.println(k);

        k = j++ + i;
        System.out.println(k);
    }
}
