package lang.immutable.address;

public class RefMain2 {

    public static void main(String[] args) {
        ImmutableAddress a = new ImmutableAddress("서울"); //x001
        ImmutableAddress b = a; // 참조값 대입 자체를 막을 방법은 없음 

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        System.out.println("---------------------------------");
        //b.setValue("부산");
        b = new ImmutableAddress("부산");

        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
