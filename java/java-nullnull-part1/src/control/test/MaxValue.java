package control.test;

import java.util.Scanner;

public class MaxValue {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num, max = 0;

        max = sc.nextInt();

        num = sc.nextInt();
        if (num > max) {
            max = num;
        }

        num = sc.nextInt();
        if (num > max) {
            max = num;
        }

        System.out.println("max = " + max);
    }
}
