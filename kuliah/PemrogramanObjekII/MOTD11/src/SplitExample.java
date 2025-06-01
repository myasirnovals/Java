import java.util.regex.Pattern;

public class SplitExample {
    public static void main(String[] args) {
        String kalimat = "apel,jeruk;pisang mangga jambu;kalapa";
        // Memecah berdasarkan koma, titik koma, atau spasi
        Pattern pola = Pattern.compile("[,; ]");
        String[] hasil = pola.split(kalimat);

        for (String buah : hasil) {
            System.out.println(buah);
        }
    }
}
