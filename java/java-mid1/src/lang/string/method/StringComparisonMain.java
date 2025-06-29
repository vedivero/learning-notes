package lang.string.method;

public class StringComparisonMain {
    public static void main(String[] args) {
        String str1 = "Hello, Java!"; //대문자 포함
        String str2 = "hello, java!"; //대문자 없음
        String str3 = "Hello, World!";

        System.out.println("str1 equals str2 : " + str1.equals(str2));
        System.out.println("str1 equalsIgnoreCAse str2 : " + str1.equalsIgnoreCase(str2));

        System.out.println("'b' compareTo 'b' : " + "a" .compareTo("b"));
        System.out.println("'b' compareTo 'a' : " + "b" .compareTo("a"));
        System.out.println("'c' compareTo 'a' : " + "c" .compareTo("a"));

        System.out.println("str1 compareTo str3 : " + str1.compareTo(str3));
        System.out.println("str1 compareTo str2 : " + str1.compareToIgnoreCase(str2));

        System.out.println("str1 start with 'Hello' : " + str1.startsWith("Hello"));
        System.out.println("str1 ends with 'Java' : " + str1.endsWith("Hello"));
    }
}
