import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        String password;
        password = getPassword();
        if (isValid(password))
            System.out.println("This password is valid!");
        else
            System.out.println("This password is invalid!");
    }

    public static boolean isValid(String str) {
        return str.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[^A-Za-z0-9]).{8,}$");
    }

    private static String getPassword() {
        String password;
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter your password: ");
        password = in.next();
        in.close();
        return password;
    }
}
