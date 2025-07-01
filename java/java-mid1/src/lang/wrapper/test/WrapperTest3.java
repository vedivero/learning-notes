package lang.wrapper.test;

public class WrapperTest3 {
    public static void main(String[] args) {
        String str = "100";

        //String -> Integer
        Integer integer = Integer.valueOf(str);
        System.out.println("integer = " + integer);

        //Integer -> int
        int intValue = integer.intValue();
        System.out.println("intValue = " + intValue);

        //int -> Integer
        Integer integer1 = Integer.valueOf(intValue);
        System.out.println("integer1 = " + integer1);
    }
}
