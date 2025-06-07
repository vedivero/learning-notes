package scanner.ex;

import java.util.Scanner;

public class ScannerWhileEx4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String productName = "";
        int price = 0;
        int qty = 0;
        int totalPrice = 0;
        while (true) {
            System.out.println("1 : 상품 입력, 2 : 결제, 3 : 프로그램 종료");
            System.out.print("숫자를 입력하세요. : ");

            int num = scanner.nextInt();

            if (num == 1) {
                scanner.nextLine();
                System.out.print("상품명을 입력하세요. : ");
                productName = scanner.nextLine();

                System.out.print("상품의 가격을 입력하세요 : ");
                price = scanner.nextInt();

                System.out.print("구매 수량을 입력하세요. : ");
                qty = scanner.nextInt();

                totalPrice += price * qty;
                System.out.println("상품명 : " + productName + ", 가격 : " + price + ", 수량 : " + qty + ", 합계 : " + totalPrice);

            } else if (num == 2) {
                System.out.println("총 가격 : "+totalPrice);
                totalPrice = 0;
            } else if (num == 3) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }
}
