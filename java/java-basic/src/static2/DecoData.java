package static2;

public class DecoData {
    private int instanceValue;
    private static int staticValue;

    public static void staticCall() {

        // static메서드는  static만 사용할 수 있다.
        //instanceValue++;    // 인스턴스 변수 접근
        //instanceMethod();   // 인스턴스 메서드 접근

        staticValue++;
        staticMethod();
    }

    public void instanceCall() {
        // instance 메서드는  static을 포함해 다 사용할 수 있다.
        instanceValue++;    // 인스턴스 변수 접근
        instanceMethod();   // 인스턴스 메서드 접근

        staticValue++;
        staticMethod();
    }

    private void instanceMethod() {
        System.out.println("instanceValue = " + instanceValue);
    }

    private static void staticMethod() {
        System.out.println("staticValue = " + staticValue);
    }
}
