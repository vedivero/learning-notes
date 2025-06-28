package lang.immutable.address;

public class MemberMainV1 {
    public static void main(String[] args) {
        Address address = new Address("서울");

        MemberV1 memberA = new MemberV1("회원A", address);
        MemberV1 memberB = new MemberV1("회원B", address);

        System.out.println("memberA = " + memberA);
        System.out.println("memberB = " + memberB);

        // 회원 B의 주소를 부산으로 변경
        memberB.getAddress().setValue("부산");
        
        // 회원 A의 주소까지 부산으로 변경됨
        System.out.println("memberA = " + memberA);
        System.out.println("memberB = " + memberB);
    }
}
