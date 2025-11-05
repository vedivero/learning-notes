package util;

import static util.MyLogger.log;

public class MyLoggerMain {

    public static void main(String[] args) {
        // Thread를 언제 실행되었는지를 확인하는 것이 중요
        log("Hello Thread");
        log(123);
    }
}
