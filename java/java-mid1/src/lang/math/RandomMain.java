package lang.math;

import java.util.Random;

public class RandomMain {
    public static void main(String[] args) {
        Random random = new Random(1);//seed가 같으면 Random의 결과가 같다.

        int nextInt = random.nextInt();
        System.out.println("nextInt = " + nextInt);

        double nextDouble = random.nextDouble();
        System.out.println("nextDouble = " + nextDouble);

        boolean nextBoolean = random.nextBoolean();
        System.out.println("nextBoolean = " + nextBoolean);

        // 범위 조회
        int randomRange = random.nextInt(10);// 0~9사이의 랜덤 숫자 출력
        System.out.println("randomRange = " + randomRange);

        int randomRange2 = random.nextInt();//1~10까지 출력
        System.out.println("randomRange2 = " + randomRange2);
    }
}
