package thread.start;

public class HelloThread extends Thread {

    // Thread 객체를 상속 받고 run() 메서드를 Override해서 사용
    @Override
    public void run() {
        // 현재 Thread의 이름을 출력
        System.out.println(Thread.currentThread().getName() + ":run()");
    }
}
