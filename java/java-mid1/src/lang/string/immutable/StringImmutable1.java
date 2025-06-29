package lang.string.immutable;

public class StringImmutable1 {
    public static void main(String[] args) {
        String str = "hello";
        str.concat(" java");
        // String Class는 불변객체이기 때문에 기존 값을 변경할 수 없음
        System.out.println("str = " + str);
    }
}
