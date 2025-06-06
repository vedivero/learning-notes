package cond.ex;

public class ExchangeRateEx {
    public static void main(String[] args) {
        int dollar = 13;
        int exchangeRate = 1300;

        if (dollar < 0) {
            System.out.println("잘못된 금액입니다.");
        } else if (dollar == 0) {
            System.out.println("환전할 금액이 없습니다.");
        } else if (dollar > 0) {
            int won = dollar * exchangeRate;
            System.out.println("환점 금액은 "+ won +"원 입니다");
        }
    }
}
