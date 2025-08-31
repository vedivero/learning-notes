package operator.v1;

import java.util.Scanner;

public class CumulativeCalculation {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int sum = 0;
        System.out.println("정수를 입력하세요 : ");
        int num1 = sc.nextInt();
        sum += num1;
        int num2 = sc.nextInt();
        sum += num2;
        int num3 = sc.nextInt();
        sum += num3;

        System.out.println("sum = " + sum);
    }
}
