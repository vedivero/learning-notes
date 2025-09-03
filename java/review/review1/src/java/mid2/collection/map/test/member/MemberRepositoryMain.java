package java.mid2.collection.map.test.member;

public class MemberRepositoryMain {

    public static void main(String[] args) {

        Member member1 = new Member("id1", "회원1");
        Member member2 = new Member("id2", "회원2");
        Member member3 = new Member("id3", "회원3");

        MemberRepository repository = new MemberRepository();
        repository.save(member1);
        repository.save(member2);
        repository.save(member3);
        System.out.println(" ");
        System.out.println("repository = " + repository);

        System.out.println(" ");
        Member findMember1 = repository.findById("id1");
        System.out.println("findMember1 = " + findMember1);

        System.out.println(" ");
        Member findMember2 = repository.findByName("회원3");
        System.out.println("findMember2 = " + findMember2);

        System.out.println(" ");
        repository.remove("id1");
        System.out.println("repository = " + repository);
    }

}
