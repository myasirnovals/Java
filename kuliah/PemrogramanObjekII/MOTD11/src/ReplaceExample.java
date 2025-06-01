import java.util.regex.Pattern;

public class ReplaceExample {
    public static void main(String[] args) {
        String noHp = "123-456-7890";
        // Mengganti semua digit menjadi tanda bintang
        Pattern pola = Pattern.compile("\\d");
        String hasil = pola.matcher(noHp).replaceAll("*");

        System.out.println("+62 " + hasil);
    }
}
