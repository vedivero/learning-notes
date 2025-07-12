package nested.nested;

public class NestedOuterMain {
    public static void main(String[] args) {
        NestedOuter nestedOuter = new NestedOuter(); // 상위 생성자 코드 없이도 생성 가능
        NestedOuter.Nested nested = new NestedOuter.Nested(); // 이 생성자만 사용 가능
        nested.print();

        System.out.println("nested.getClass() = " + nested.getClass());

    }
}
