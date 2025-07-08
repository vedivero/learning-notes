package enumeration.ex1;

import enumeration.ex0.DiscountService;

public class StringGradeEx1_2 {
    public static void main(String[] args) {
        int price = 10_000;
        DiscountService discountService = new DiscountService();

        //존재하지 않는 등급
        int vip = discountService.discount("VIP", price);
        System.out.println("VIP 등급의 할인 금액 : "+ vip);

        //오타
        int diamondd = discountService.discount("DIAMONDD", price);
        System.out.println("DIAMOND 등급의 할인 금액 : "+ diamondd);
        
        //문자열 상수를 사용하더라도, 사전에 정의된 문자열 이외에 값을 사용 가능한 문제
    }
}
