package loop;

public class Break2 {
    public static void main(String[] args) {
        int sum = 0;
        int i = 1;

        for (; ; ) {
            sum += i;
            System.out.println("sum = " + sum);
            if (sum > 10) {
                System.out.println("sum의 합계가 10을 초과하여 반복문을 종료합니다.");
                break;
            }
            i++;
        }
    }
}
