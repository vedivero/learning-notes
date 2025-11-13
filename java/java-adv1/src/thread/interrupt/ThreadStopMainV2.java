package thread.interrupt;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class ThreadStopMainV2 {

    public static void main(String[] args) {
        MyTast task = new MyTast();
        Thread thread = new Thread(task, "work");
        thread.start();

        sleep(4000);
        log("작업 중단 지시, runFlag = false");
        thread.interrupt();
        log("work Thread Interrupt State 1 = " + thread.isInterrupted());
    }

    static class MyTast implements Runnable {

        @Override
        public void run() {
            try {
                while (true) {
                    log("작업 중");
                        Thread.sleep(3000);
                    }
            } catch (InterruptedException e){
                log("work Thread Interrupt Status 2 = " + Thread.currentThread().isInterrupted());
                log("interrupt message = " + e.getMessage());
                log("state = " + Thread.currentThread().getState());
            }
            log("자원 정리");
            log("자원 종료");
        }
    }
}
