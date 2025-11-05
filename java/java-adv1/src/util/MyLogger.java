package util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class MyLogger {

    // 시간을 표현해야 하니 포매팅이 필요
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

    // String으로 하지 않고 Object로 한 이유
    // String은 문자열에 한정적, 숫자는 못 받음
    // Object로 넘어오면 유연하게 데이터를 처리
    // (%s <- toString 처리)
    public static void log(Object object) {
        String time = LocalTime.now().format(formatter);
        System.out.printf("%s [%9s] %s\n", time, Thread.currentThread().getName(), object);// 항상 9칸을 차지하도록 설정
    }
}