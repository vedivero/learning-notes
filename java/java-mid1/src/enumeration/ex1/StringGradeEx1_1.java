package enumeration.ex1;

import enumeration.ex0.DiscountService;

public class StringGradeEx1_1 {
    public static void main(String[] args) {
        int price = 10_000;
        enumeration.ex0.DiscountService discountService = new DiscountService();
        int basic = discountService.discount(StringGrade.BASIC, price);
        int gold = discountService.discount(StringGrade.GOLD, price);
        int diamond = discountService.discount(StringGrade.DIAMOND, price);

        System.out.println("BASIC 등급의 할인 금액 : "+ basic);
        System.out.println("GOLD 등급의 할인 금액 : "+ gold);
        System.out.println("DIAMOND 등급의 할인 금액 : "+ diamond);
    }
}
