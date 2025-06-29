package lang.string;

public class StringConcatMain {
    public static void main(String[] args) {
        String a = "hello"; //x001
        String b = " java"; //x002

        String result1 = a.concat(b); // x001.concat(x002)
        String result2 = a + b; // x001 + x002
        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);
    }
}
