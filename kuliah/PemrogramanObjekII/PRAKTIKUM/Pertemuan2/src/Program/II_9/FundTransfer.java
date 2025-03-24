package Program.II_9;

public class FundTransfer {
    public static boolean transferFunds(Account xAcc, Account yAcc, int amt) {
        xAcc.debit(amt);
        yAcc.credit(amt);
        System.out.println("Completed fund transfer");
        return true;
    }
}
