package lang.wrapper;

public class WrapperClassMain {
    public static void main(String[] args) {
        Integer newInteger = new Integer(10);
        Integer integerObj = Integer.valueOf(10);

        System.out.println("newInteger = " + newInteger);
        System.out.println("integerObj = " + integerObj);

        Long longObj = Long.valueOf(100);
        Double doubleObj = Double.valueOf(10.5);

        System.out.println("longObj = " + longObj);
        System.out.println("doubleObj = " + doubleObj);

        int intVAlue = integerObj.intValue();
        System.out.println("intVAlue = " + intVAlue);

        long longValue = longObj.longValue();
        System.out.println("longValue = " + longValue);

        System.out.println("비교 == ");
        System.out.println(newInteger == integerObj);
        System.out.println(newInteger.equals(integerObj));

    }
}
