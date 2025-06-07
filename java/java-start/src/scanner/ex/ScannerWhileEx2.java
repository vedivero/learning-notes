package scanner.ex;

import java.util.Scanner;

public class ScannerWhileEx2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("상품 가격 계산 프로그램 / '-1'을 입력하면, 프로그램 종료");

        while (true) {
            System.out.print("상품의 가격을 입력하세요 : ");
            int price = scanner.nextInt();

            if (price == -1) {
                System.out.println("상품 가격 계산 프로그램을 종료합니다.");
                break;
            }

            System.out.print("구매하려는 수량을 입력하세요. : ");
            int qty = scanner.nextInt();

            int totalPrice = price * qty;
            System.out.println("총 가격 = " + totalPrice);
        }
    }
}
