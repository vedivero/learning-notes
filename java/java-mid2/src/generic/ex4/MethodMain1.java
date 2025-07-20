package generic.ex4;

public class MethodMain1 {
    public static void main(String[] args) {
        Integer i = 10;
        Object object = GenericMethod.objMethod(i);

        //Integer result = (Integer) GenericMethod.objMethod(i);
        // 넣은 타입으로 반환 받고 싶다면,
        // 타입 인자(Type Argument) 명시적 전달
        Integer result = GenericMethod.<Integer>genericMethod(i);
        Integer integerValue = GenericMethod.<Integer>numberMethod(10);
        Double doubleValue = GenericMethod.<Double>numberMethod(20.0);

        //String s = GenericMethod.<String>numberMethod("Hello");

        // 인자를 토대로 타입 추론
        Integer result1 = GenericMethod.genericMethod(i);
        Integer integerValue1 = GenericMethod.numberMethod(10);
        Double doubleValue1 = GenericMethod.numberMethod(20.0);

    }
}
