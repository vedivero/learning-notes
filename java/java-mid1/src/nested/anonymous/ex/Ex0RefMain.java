package nested.anonymous.ex;

public class Ex0RefMain {

    public static void main(String[] args) {
        printMessage("hello Java");
        printMessage("hello Spring");
    }

    public static void printMessage(String message) {
        System.out.println("프로그램 시작");
        System.out.println(message);
        System.out.println("프로그램 종료");
    }
}
