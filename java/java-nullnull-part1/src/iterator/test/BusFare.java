package iterator.test;

import java.util.Scanner;

public class BusFare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("나이를 입력하세요. :");

        int age = sc.nextInt();
        int busFare = 1000;
        double discount = 0.75;

        int result = 0;
        if (age < 20) {
            result = (int) (busFare * discount);
        } else {
            result = busFare;
        }

        System.out.println("나이 = " + age + ", 최종 요금 = " + result);

    }
}
