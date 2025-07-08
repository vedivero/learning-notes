package enumeration.ex2;

public class ClassGradeEx2_2 {
    public static void main(String[] args) {
        int price = 10000;
        DiscountService discountService = new DiscountService();

        /*ClassGrade newClassGrade = new ClassGrade();
        int reesult = discountService.discount(newClassGrade, price);
        System.out.println("newClassGrade 등급의 할인 금액: " + reesult);*/
        // 회원 등급을 조정할 수는 없게 되었지만, 인스턴스를 외부에서 임의로 생성가능
    }
}
