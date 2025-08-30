package console.io;

import java.util.Scanner;

public class ScannerTestMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("나이를 입력하세요:");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("이름을 입력하세요:");
        String name = sc.nextLine();
        System.out.println("당신의 나이는 " + age + "살이고, 이름은 " + name + "입니다.");
    }
}
