package operator.v1;

import java.util.Scanner;

public class AverageMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("두 정수를 입력하세요.");
        int num1 = sc.nextInt();
        sc.nextLine();
        int num2 = sc.nextInt();

        System.out.printf("AVG : %.2f\n", (num1 + num2) / 2.0);
    }
}
