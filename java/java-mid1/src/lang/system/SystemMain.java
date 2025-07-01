package lang.system;

import java.util.Arrays;

public class SystemMain {
    public static void main(String[] args) {
        //현재 시간(밀리초)
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println("currentTimeMillis = " + currentTimeMillis);

        //현재 시간(나노초)
        long nanoTime = System.nanoTime();
        System.out.println("nanoTime = " + nanoTime);

        //운영체제의 환경 변수
        System.out.println("getenv = " + System.getenv());

        //자바가 사용하는 시스템 속성
        System.out.println("properties = " + System.getProperties());
        System.out.println("Java version = "+System.getProperty("java.version"));

        //배열을 고속으로 복사
        char[] originalArray = {'h', 'e', 'l', 'l', 'o'};
        char[] copiedArray = new char[5];

        System.arraycopy(originalArray, 0, copiedArray, 0, originalArray.length);

        //배열 출력
        System.out.println("copiedArray = " + copiedArray);
        System.out.println("copiedArray = " + Arrays.toString(copiedArray));

        //프로그램 종료
        System.exit(0);
        
    }
}
