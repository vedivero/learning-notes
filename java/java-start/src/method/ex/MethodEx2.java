package method.ex;

public class MethodEx2 {
    public static void main(String[] args) {
        message("Hello Java", 5);
    }

    public static void message(String msg, int a) {
        for (int i = 0; i < a; i++) {
            System.out.println(msg);
        }
    }
}
