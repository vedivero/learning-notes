package scanner.ex;

import java.util.Scanner;

public class ScannerWhileEx3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = 0;
        int sum = 0;
        int num = 0;

        System.out.println("숫자를 입력하세요. ('-1'을 입력하면, 프로그램이 종료됩니다.)");

        /*while (true) {
            num = scanner.nextInt();
            if (num == -1) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            sum += num;
            count++;
        }*/
        while ((num = scanner.nextInt()) != -1) {
            sum += num;
            count++;
        }

        double average = (double) sum / count;
        System.out.println("입력한 숫자들의 합계 : " + sum);
        System.out.println("입력한 숫자들의 평균 : " + average);

    }
}
