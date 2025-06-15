package oop.ex;

public class AccountMain {
    public static void main(String[] args) {
        Account account = new Account();

        account.balance = 1000000;
        account.deposit(20000);
        account.withdraw(500000);

        System.out.println("현재 잔고 : " + account.balance);
    }
}
