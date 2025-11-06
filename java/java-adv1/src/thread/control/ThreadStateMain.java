package thread.control;

import util.MyLogger;

import static util.MyLogger.*;

public class ThreadStateMain {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyRunnable(), "myThread");
        log("thread.getState() = " + thread.getState()); // [     main] thread.getState() = NEW
        log("thread.start()");
        thread.start();
        thread.sleep(1000);
        log("myThread.state3 = " + thread.getState()); // [     main] myThread.state3 = TIMED_WAITING
        thread.sleep(4000);
        // 종료된 후의 Thread State
        log("myThread.state5 = " + thread.getState()); // [     main] myThread.state5 = TERMINATED
        log("end");
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            try {
                log("start");
                // MyRunnable이 실행될 때의 상태 확인해보기
                Thread thread = Thread.currentThread();
                log("myThread.state2 = " + thread.getState()); // [ myThread] myThread.state2 = RUNNABLE
                log("sleep() start");

                // sleep 상태의 Thread State 확인해보기
                thread.sleep(3000);

                // 깨고 나서의 Thread State
                log("myThread.state4 = " + thread.getState()); // [ myThread] myThread.state4 = RUNNABLE
                log("sleep() end");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
