package lang.string.method;

public class StringUtilsMain2 {
    public static void main(String[] args) {
        int num = 100;
        boolean bool = true;
        Object obj = new Object();
        String str = "Hello Java!";

        String format1 = String.format("num: %d, bool: %b, str: %s", num, bool, str);
        System.out.println(format1);

        String format2 = String.format("숫자 : %.2f", 10.123123);
        System.out.println(format2);

        //printf
        System.out.printf("숫자 : %.2f\n", 10.123123);

        //matches method
        String regex = "Hello, (Java!|World)";
        System.out.println("'str이' 패턴과 일치하는가? "+str.matches(regex));
    }
}
