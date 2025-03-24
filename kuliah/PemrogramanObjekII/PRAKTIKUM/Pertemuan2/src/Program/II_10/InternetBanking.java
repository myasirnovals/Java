package Program.II_10;

public class InternetBanking {
    public static void main(String[] args) {
        Account xAcc = new Account(1, 1000);
        Account yAcc = new Account(2, 1200);
        FundTransfer.transferFunds(xAcc, yAcc, 1400);
        System.out.println("xAcc’s current balance " +
                xAcc.getCurrentBalance());
        System.out.println("yAcc’s current balance " +
                yAcc.getCurrentBalance());
        System.out.println("Completed execution of main method");
    }
}
