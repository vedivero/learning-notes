package operator;

public class Operator1 {
    public static void main(String[] args) {
        int a = 5;
        int b = 2;

        int sum = a + b;
        System.out.println("a + b = " + sum);   // 전부 문자열로 출력

        int diff = a - b;
        System.out.println("a - b = " + diff);

        int multi = a * b;
        System.out.println("a * b = " + multi);

        int div = a / b;
        System.out.println("a / b = " + div);

        int mod = a % b;
        System.out.println("a % b = " + mod);

        //int z = 10 / 0; // java.lang.ArithmeticException: / by zero
    }
}
