package poly.basic;

public class CastingMain6 {
    public static void main(String[] args) {
        Parent parent1 = new Parent();
        System.out.println("parent1 호출");
        call(parent1);

        Parent parent2 = new Child();
        System.out.println("parent2 호출");
        call(parent2);
    }

    private static void call(Parent parent){
        parent.parentMethod();
        // Child 인스터인 경우에 childMetohd() 실행
        // if()문 안에 변수를 선언 가능 (Java16버전 이후)
        if (parent instanceof Child child) {
            System.out.println("Child 인스턴스 맞음");
            child.childMetohd();
        }
    }
}
