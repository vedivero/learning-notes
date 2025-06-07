package scanner.ex;

import java.util.Scanner;

public class ScannerEx2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("홀수/짝수를 판별하는 프로그램 입니다. 숫자를 입력해주세요.");
        int num = scanner.nextInt();

        String result = (num % 2 == 0) ? "짝수입니다." : "홀수입니다.";
        System.out.println("입력하신 숫자는 " + result);
    }
}
