package lang.immutable.change;

public class ImmutableMain2 {
    public static void main(String[] args) {
        ImmutableObj immutableObj1 = new ImmutableObj(10);
        immutableObj1.add(30);

        System.out.println(immutableObj1.getValue());
        // 꼭 반환 값을 받는 변수를 사용해야 함
    }
}
