package access.ex;

public class MaxCounter {
    private int count = 0;
    private int max = 0;

    MaxCounter(int max) {
        this.max = max;
    }

    public void increment() {
        if (max <= count) {
            System.out.println("최대 값에 도달했습니다.");
        } else {
            count++;
            System.out.println("값을 증가합니다. 현재 값 : " + count);
        }
    }

    public int getCount() {
        return count;
    }

}
