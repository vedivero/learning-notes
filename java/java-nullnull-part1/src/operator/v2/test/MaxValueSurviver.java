package operator.v2.test;

import java.util.Scanner;

public class MaxValueSurviver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();
        int max = 0;

        input = sc.nextInt();
        max = (input > max) ? input : max;

        input = sc.nextInt();
        max = (input > max) ? input : max;

        System.out.println("max = " + max);
    }
}
