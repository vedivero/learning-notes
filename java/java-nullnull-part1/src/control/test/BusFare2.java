package control.test;

import java.util.Scanner;

public class BusFare2 {


    final static int BUS_FARE = 1000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("나이를 입력하세요. :");

        int age = sc.nextInt();

        int result = 0;
        if (age > 20) {
            result = BUS_FARE;
        } else if(age >13){
            result = (int) (BUS_FARE * 0.25);
        } else if (age > 3) {
            result = (int) (BUS_FARE * 0.5);
        }
        System.out.println("나이 = " + age + ", 최종 요금 = " + result);

    }
}
