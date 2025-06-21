package final1.ex;

public class MemberMain {
    public static void main(String[] args) {
        Member member = new Member("Id", "name");
        member.print();
        member.changeData("name2");
        member.print();
    }
}
