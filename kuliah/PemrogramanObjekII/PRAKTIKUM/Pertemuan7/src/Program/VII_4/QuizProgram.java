package Program.VII_4;

import java.util.*;

public class QuizProgram {
    public static void main(String[] args) {
        Map<String, String> questionBank = new HashMap<>();
        questionBank.put("Apa ibu kota Indonesia?", "Jakarta");
        questionBank.put("Siapa penemu lampu pijar?", "Thomas Edison");
        questionBank.put("Berapa hasil dari 7 x 6?", "42");
        questionBank.put("Apa nama planet terbesar di tata surya?", "Jupiter");
        questionBank.put("Siapa presiden pertama Indonesia?", "Soekarno");
        questionBank.put("Apa simbol kimia untuk air?", "H2O");
        questionBank.put("Berapa jumlah warna dalam pelangi?", "7");
        questionBank.put("Apa nama hewan tercepat di darat?", "Cheetah");
        questionBank.put("Berapa sisi yang dimiliki segitiga?", "3");
        questionBank.put("Apa nama lautan terbesar di dunia?", "Samudra Pasifik");

        List<String> questions = new ArrayList<>(questionBank.keySet());
        Collections.shuffle(questions);
        List<String> selectedQuestions = questions.subList(0, 5);

        int score = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selamat datang di kuis! Jawab 5 soal berikut:");
        System.out.println("------------------------------------------------");

        for (String question : selectedQuestions) {
            System.out.println("Soal: " + question);
            System.out.print("Jawaban Anda: ");
            String userAnswer = scanner.nextLine().trim();

            if (userAnswer.equalsIgnoreCase(questionBank.get(question))) {
                System.out.println("Benar!\n");
                score++;
            } else {
                System.out.println("Salah. Jawaban yang benar adalah: " + questionBank.get(question) + "\n");
            }
        }

        System.out.println("------------------------------------------------");
        System.out.println("Kuis selesai! Skor Anda: " + score + " dari 5.");
        scanner.close();
    }
}
