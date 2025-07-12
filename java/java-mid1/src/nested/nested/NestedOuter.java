package nested.nested;

public class NestedOuter {

    private static int outClassValue = 3;
    private int outInstanceValue = 2;

    static class Nested {
        private int nestedInstanceValue = 1;

        public void print() {
            //자신의 멤버에 접근 가능
            System.out.println(nestedInstanceValue);

            //외부 인스턴스 멤버에는 접근 불가
            //System.out.println(outInstanceValue);

            //static이어도 private은 접근 불가하지만, 정적 중첩 클래스는 접근 가능
            System.out.println(NestedOuter.outClassValue);

        }
    }
    // 클래스를 다른 파일로 선언한 것과 같은 구조
    // *private 접근 제어자에 접근 할 수 있는 것 뿐.
}
