package lang.wrapper.test;

public class WrapperTest4 {
    public static void main(String[] args) {
        String str = "100";

        //String -> Integer
        Integer integer = Integer.valueOf(str);
        System.out.println("integer = " + integer);

        //Integer -> int
        int intValue = integer;
        System.out.println("intValue = " + intValue);

        //int -> Integer
        Integer integer1 = intValue;
        System.out.println("integer1 = " + integer1);
    }
}
