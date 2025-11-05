package thread.start;

import static util.MyLogger.*;

public class InnerRunnableMainV1 {

    public static void main(String[] args) {

        log("main() start");

        MyRunnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
        
        log("main() end");
    }

    // 정적 중첩 클래스 = 특정한 클래스 안에서 사용하는 클래스
    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            log("run()");
        }
    }
}
