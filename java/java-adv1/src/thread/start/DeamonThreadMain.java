package thread.start;

public class DeamonThreadMain {
    public static void main(String[] args) {

        /* Main Thread가 실행한 영역 */
        System.out.println(Thread.currentThread().getName() + " : main() start");
        DeamonThread deamonThread = new DeamonThread();
        deamonThread.setDaemon(true); // 데몬 쓰레드 여부를 판단
        /* Main Thread가 실행한 영역 */
        
        deamonThread.start(); // 여기서 프로그램이 종료
        // 사용자 쓰레드는 다 끝.
        // 남은 것은 데몬 쓰레드 뿐
        // = 자바 종료

        /* Main Thread가 실행한 영역 */
        System.out.println(Thread.currentThread().getName() + " : main() end");
        /* Main Thread가 실행한 영역 */
    }

    static class DeamonThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " : run()");

            try {
                Thread.sleep(10000); // 10초간 실행
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
