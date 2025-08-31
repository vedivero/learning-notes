package operator.v2;

public class RelationOperation {
    public static void main(String[] args) {
        int a = 5, b = 10;
        System.out.println(a == b);
        System.out.println(a != b);
        System.out.println(a > 5);
        System.out.println(b < 5);
        System.out.println(b >= 10);
        System.out.println(b <= a + 5);

        System.out.println(" ");
        System.out.println(300 == 299);
        System.out.println(300.0F == 299.999998F); // true = 부동 소수점 오차 때문
        // 내부에서 300.0F - 299.999998F 연산
        System.out.println(300.0F == 299.999998);

        System.out.println(" ");
        int c = 5, d = 10;
        System.out.println(c > d);
        System.out.println(3 > c);
        //System.out.println(3 < a < b);
    }
}
