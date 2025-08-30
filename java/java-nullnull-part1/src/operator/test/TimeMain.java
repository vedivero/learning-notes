package operator.test;

import java.util.Scanner;

public class TimeMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("초(Seconds)를 입력하세요.");
        int inputNum = sc.nextInt();
        int hour = inputNum / 3600;
        int minute = (inputNum % 3600) / 60;
        int seconds = inputNum % 60;
        System.out.printf("%02d:%02d:%02d", hour, minute, seconds);

    }
}
