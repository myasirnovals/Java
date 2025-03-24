package Tugas.II_9;

import Tugas.II_8.Account;

public class FundTransfer {
    public static boolean transferFunds(Account xAcc, Account yAcc, int amt) {
        xAcc.debit(amt);
        yAcc.credit(amt);
        System.out.println("Completed fund transfer");
        return true;
    }
}
