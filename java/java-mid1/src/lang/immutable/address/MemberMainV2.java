package lang.immutable.address;

public class MemberMainV2 {
    public static void main(String[] args) {
        ImmutableAddress address = new ImmutableAddress("서울");

        MemberV2 memberA = new MemberV2("회원A", address);
        MemberV2 memberB = new MemberV2("회원B", address);

        System.out.println("memberA = " + memberA);
        System.out.println("memberB = " + memberB);

        // 회원 B의 주소를 부산으로 변경
        //memberB.getAddress().setValue("부산");    // final로 인한 컴파일 오류

        // memberB가 불변이 아닌, ImmutableAddress객체의 멤버 변수가 불변
        memberB.setAddress(new ImmutableAddress("부산"));
        
        // 회원 A의 주소까지 부산으로 변경됨
        System.out.println("memberA = " + memberA);
        System.out.println("memberB = " + memberB);
    }
}
