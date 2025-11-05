package thread.start;
// 실무에서 사용
// 장점
// - 자유로운 상속
// - 코드 분리
// - 여러 Thread가 동일한 Runnable 객체를 공유 = 자원 관리 효율
// 단점
// - 코드가 복잡해 질 가능성
public class HelloRunnable implements Runnable {

    @Override
    public void run() {
        // 불편한 것
        // 스레드 이름을 알아보는 코드가 너무 길다.
        // 실행 시간을 확인하고 싶음
        // 실무에서는 로거로 해결
        System.out.println(Thread.currentThread().getName());
     }
}
