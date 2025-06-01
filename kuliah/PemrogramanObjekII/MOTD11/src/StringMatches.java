import java.util.Scanner;

public class StringMatches {
    public static void main(String[] args) {
        String ssn;
        ssn = getSsn();
        if (isMatch(ssn))
            System.out.println("This string is valid!");
        else
            System.out.println("This string is invalid!");
    }

    public static boolean isMatch(String str) {
        return str.matches(".?[0-5]{10}");
    }

    private static String getSsn() {
        String ssn;
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter your string: ");
        ssn = in.next();
        in.close();
        return ssn;
    }
}
