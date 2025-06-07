package scanner;

import java.util.Scanner;

public class ScannerWhile3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("입력한 모든 숫자의 합을 구해주는 프로그램입니다. ");
        int sum = 0;
        while (true) {
            System.out.println("합산할 숫자를 입력해 주세요. ('0'을 입력하면 프로그램을 종료합니다.)");
            int num = scanner.nextInt();
            sum += num;
            if (num == 0) {
                System.out.println("지금까지 입력한 모든 숫자의 합은 : " + sum + "입니다. 프로그램을 종료합니다.");
                break;
            }
        }
    }
}
