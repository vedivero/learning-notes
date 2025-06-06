package cond;

public class If6 {
    public static void main(String[] args) {
        int price = 10000;
        int age = 10;
        int discount = 0;

        if (price >= 10000) {
            discount += 1000;
            System.out.println("10,000원 이상 구매, 1,000원 할인");
        } else if (age >= 10) {
            discount += 1000;
            System.out.println("어린이 1,0000원 할인");
        } else {
            System.out.println("할인이 없습니다.");
        }

        System.out.println("총 상품 가격은 " + (price - discount) + "원 입니다.");
    }
}