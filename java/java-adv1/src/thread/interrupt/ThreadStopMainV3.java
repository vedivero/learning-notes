package thread.interrupt;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class ThreadStopMainV3 {

    public static void main(String[] args) {
        MyTast task = new MyTast();
        Thread thread = new Thread(task, "work");
        thread.start();

        sleep(100);
        log("작업 중단 지시 - thread.interrupt()");
        thread.interrupt();
        log("work Thread Interrupt State 1 = " + thread.isInterrupted());
    }

    static class MyTast implements Runnable {

        @Override
        public void run() {
            
            // 인터럽트에 걸린게 아닐 때 돌리는 것
            while (!Thread.currentThread().isInterrupted()) {   // 인터럽트의 상태를 변경하지는 않음
                log("작업 중");
            }

            log("work Thread Interrupt Status 2 = " + Thread.currentThread().isInterrupted());
            log("자원 정리");
            log("자원 종료");
        }
    }
}
