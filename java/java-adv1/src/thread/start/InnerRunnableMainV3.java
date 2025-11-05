  package thread.start;

import static util.MyLogger.log;

public class InnerRunnableMainV3 {

    public static void main(String[] args) {

        log("main() start");

        // 더 간단히 하는 방법
        // 바로 생성자를 매개 변수에 선언
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                log("run()");
            }
        });
        thread.start();
        
        log("main() end");
    }

}
