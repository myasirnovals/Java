package Tugas.II_8;

public class Account {
    private int accountNumber;
    private int currentBalance;

    public Account() {

    }

    public Account(int accountNumber, int currentBalance) {
        this.accountNumber = accountNumber;
        this.currentBalance = currentBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(int currentBalance) {
        this.currentBalance = currentBalance;
    }

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
}
