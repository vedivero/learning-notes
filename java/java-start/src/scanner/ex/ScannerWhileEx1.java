package scanner.ex;

import java.util.Scanner;

public class ScannerWhileEx1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("'종료'를 입력하면 프로그램이 종료됩니다.");

        while (true) {
            System.out.print("이름을 입력하세요. : ");
            String str = scanner.nextLine();
            if (str.equals("종료")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            System.out.print("나이를 입력하세요. : ");
            int age = scanner.nextInt();
            scanner.nextLine();

            System.out.println("입력한 이름 : " + str + ", 나이 : " + age);
        }
    }
}
