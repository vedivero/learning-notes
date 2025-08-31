package operator.v2;

public class ShortCircuit {
    public static void main(String[] args) {
        int x = 10;
        //boolean result = x > 3 || ++x > 10 || ++x > 6; // true가 나오면 그 뒤 연산은 수행하지 않음
        boolean result = x > 3 && ++x > 10 && ++x > 6; // and연산자는 같음을 비교해야하기 때문에 수행됨
        System.out.println("result = " + result);
        System.out.println("x = " + x);
    }
}
