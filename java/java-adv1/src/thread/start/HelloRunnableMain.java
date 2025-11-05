package thread.start;

public class HelloRunnableMain {
    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName() + " : main() start");

        HelloRunnable runnable = new HelloRunnable();
        Thread thread = new Thread(runnable);   // 실행할 작업을 생성자로 전달
        thread.start();

        System.out.println(Thread.currentThread().getName() + " : main() end");
    }
}
