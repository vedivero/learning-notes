package thread.start;

public class HelloThreadMain {
    public static void main(String[] args) {

        //Java가 만드는 기본 Thread = main
        System.out.println(Thread.currentThread().getName() + " : main() start");

        HelloThread helloThread = new HelloThread();
        System.out.println(Thread.currentThread().getName() + " : start() start");
        helloThread.start();
        System.out.println(Thread.currentThread().getName() + " : start() end");

        System.out.println(Thread.currentThread().getName() + " : main() end");

    }
}
