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
        System.out.println(Thread.currentThread().getName());
     }
}
