package method.ex;

import java.util.Scanner;

public class MethodEx4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int balance = 10000;

        System.out.println("1. 입금 | 2. 출금 | 3. 잔액 확인 | 4. 종료");

        while (true) {

            int num = scanner.nextInt();
            if (num == 1) {
                System.out.print("입금액을 입력하세요.");
                int amount = scanner.nextInt();
                balance = deposit(balance,amount);
                System.out.println(amount+"원을 입급하였습니다. 현재 잔액 : "+balance );
            } else if (num == 2) {
                System.out.print("출금액을 입력하세요.");
                int amount = scanner.nextInt();
                balance = withdraw(balance, amount);
                System.out.println(amount+"원을 출급하였습니다. 현재 잔액 : "+balance );
            } else if (num == 3) {
                System.out.print("현재 잔액 : "+balance+"원");
            } else if (num == 4) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

        }
    }

    public static int deposit(int balance, int amount) {
        balance += amount;
        return balance;
    }

    public static int withdraw(int balance, int amount) {
        if (amount > balance) {
            System.out.println("잔액이 부족합니다.");
        } else {
            balance -= amount;
        }
        return balance;
    }

}
