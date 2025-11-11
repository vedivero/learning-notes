package thread.control;

public class CheckedExceptionMain {


    public static void main(String[] args) throws Exception {
        throw new Exception();
    }

    static class CheckedRunnable implements Runnable {

        // 부모 메서드가 체크 예외를 던지지 않으면,
        // 재 정의된 자식 메서드도 체크 예외를 던질 수 없다.
        @Override
        public void run() /*Exception*/{
            //throw new Exception(); // 주석 해제하면 에러 발생
        }

    }
}