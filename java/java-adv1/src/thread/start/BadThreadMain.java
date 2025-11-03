package thread.start;

public class BadThreadMain {
    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName() + " : main() start");   // main이 실행

        HelloThread helloThread = new HelloThread();

        System.out.println(Thread.currentThread().getName() + " : start() 호출 전");   // main이 실행

        //helloThread.start();

        helloThread.run();  // run() 직접 실행
        // 이 Thread는 누가 실행할까?
        // main Thread가 실행한다.
        // main Thread가 순서 대로 모든 것을 처리
        // main Thread가 main Thread 자기 자신을 호출한 꼴
        // = 객체 덩어리일 뿐

        // ** start()로 호출해야 스택 영역에 프레임이 생성되고 별도의 Thread가 실행되는 System Call이 된다.

        System.out.println(Thread.currentThread().getName() + " : start() 호출 후");   // main이 실행

        System.out.println(Thread.currentThread().getName() + " : main() end");   // main이 실행

    }
}
