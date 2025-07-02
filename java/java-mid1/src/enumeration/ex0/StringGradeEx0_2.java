package enumeration.ex0;

public class StringGradeEx0_2 {
    public static void main(String[] args) {
        int price = 10_000;
        
        DiscountService discountService = new DiscountService();
        
        //존재하지 않는 등급을 입력할 가능성이 있음
        int vip = discountService.discount("VIP", price);
        System.out.println("VIP 등급의 할인 금액 : "+ vip);

        //일일이 입력할 경우, 오타의 가능성이 있음
        int diamonnd = discountService.discount("DIAMONND", price);
        System.out.println("diamonnd 등급의 할인 금액 : "+ diamonnd);

        //대소문자 구분
        int gold = discountService.discount("gold", price);
        System.out.println("gold 등급의 할인 금액 : "+ gold);
        
        //타입 안정성 부족
        //데이터 일관성
    }
}
