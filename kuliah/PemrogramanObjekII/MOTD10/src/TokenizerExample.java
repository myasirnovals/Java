import java.util.Scanner;
import java.util.StringTokenizer;

public class TokenizerExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence and press Enter:");
        String sentence = scanner.nextLine();

        StringTokenizer tokenizer = new StringTokenizer(sentence);
        System.out.printf("Number of elements: %d\nThe tokens are:\n", tokenizer.countTokens());

        while (tokenizer.hasMoreTokens())
            System.out.println(tokenizer.nextToken());
    }
}
