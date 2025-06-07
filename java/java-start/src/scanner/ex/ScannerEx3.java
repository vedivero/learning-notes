package scanner.ex;

import java.util.Scanner;

public class ScannerEx3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("주문하실 음식을 입력해주세요.");
        String foodName = scanner.nextLine();

        System.out.print("가격을 입력해주세요.");
        int foodPrice = scanner.nextInt();

        System.out.print("수량을 입력해주세요.");
        int foodQty = scanner.nextInt();

        int totalPrice = foodPrice * foodQty;

        System.out.println("주문하신 음식 " + foodName + ", " + foodQty + "개의 총 가격은 : " + totalPrice + "원 입니다." );
    }
}
