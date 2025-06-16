import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ZakatValidation {
    private static final String POSITIVE_NUMBER_REGEX = "^\\d+(\\.\\d+)?$";

    public static boolean isValidPositiveNumber(String input) {
        Pattern pattern = Pattern.compile(POSITIVE_NUMBER_REGEX);
        Matcher matcher = pattern.matcher(input);
        return !matcher.matches();
    }

    public static boolean isValidPositiveInteger(String input) {
        Pattern pattern = Pattern.compile("^\\d+$");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}