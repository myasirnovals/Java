package Program.II_8;

public class Account {
    private int accountNumber;
    private int currentBalance;
    //.....
    public void credit(int amt) {
        currentBalance = currentBalance + amt;
    }
    public void debit(int amt) {
        int tempBalance = currentBalance - amt;
        if (tempBalance < 0) {
            int i = 1 / 0;
            System.out.println(i);
        }
        currentBalance = tempBalance;
    }
//.....
}
