import java.util.regex.*;

public class FindExample {
    public static void main(String[] args) {
        String kalimat = "Saya suka belajar Java dan JavaScript.";
        Pattern pola = Pattern.compile("Java");
        Matcher matcher = pola.matcher(kalimat);

        while (matcher.find()) {
            System.out.println("Ditemukan '" + matcher.group() + "' di index " + matcher.start());
        }
    }
}
