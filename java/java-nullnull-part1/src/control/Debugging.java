package control;

import java.util.Scanner;

public class Debugging {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        if (input > 10) {
            System.out.println("if(){}");
            input = 10;
        }
        System.out.println("input = " + input);
        System.out.println("main()-end");
    }
}
