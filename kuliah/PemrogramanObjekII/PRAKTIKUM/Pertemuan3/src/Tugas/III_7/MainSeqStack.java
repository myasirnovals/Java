package Tugas.III_7;

public class MainSeqStack {
    public static void main(String[] args) {
        SeqStack stack = new SeqStack();
        int temp = 0;

        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }

        temp = stack.pop();
        System.out.println(temp);

        temp = stack.pop();
        System.out.println(temp);
    }
}
