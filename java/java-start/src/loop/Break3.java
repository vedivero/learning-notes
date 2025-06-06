package loop;

public class Break3 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; ;i++ ) {
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
