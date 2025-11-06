package thread.control;

import thread.start.HelloRunnable;

import static util.MyLogger.log;

public class ThreadInfoMain {
    public static void main(String[] args) {

        System.out.println("main Thread");
        // main Thread 정보 출력하기
        Thread mainThread = Thread.currentThread();
        log("main Thread = " + mainThread);

        // Thread의 ID 조회, 자바가 생성, 중복되지 않음
        log("main Thread.threadId() = " + mainThread.threadId());

        // Thread의 name을 조회
        log("main Thread.getName() = " + mainThread.getName());

        // Thread의 우선 순위 조회, 값이 높을 수록 많이 실행
        log("main Thread.getPriority() = " + mainThread.getPriority());

        // Thread 상태 조회
        log("main Thread.getThreadGroup() = " + mainThread.getThreadGroup());

        // Thread 상태 조회
        log("main Thread.getState() = " + mainThread.getState());

        System.out.println(" ");

        // my Thread 정보 출력하기
        System.out.println("my Thread");
        Thread myThread = new Thread(new HelloRunnable(), "myThread");
        log("my Thread = " + mainThread);

        // Thread의 ID 조회, 자바가 생성, 중복되지 않음
        log("my Thread.threadId() = " + myThread.threadId());

        // Thread의 name을 조회
        log("my Thread.getName() = " + myThread.getName());

        // Thread의 우선 순위 조회, 값이 높을 수록 많이 실행
        log("my Thread.getPriority() = " + myThread.getPriority());

        // Thread 상태 조회
        log("my Thread.getThreadGroup() = " + myThread.getThreadGroup());

        // Thread 상태 조회
        log("my Thread.getState() = " + myThread.getState());
    }
}
