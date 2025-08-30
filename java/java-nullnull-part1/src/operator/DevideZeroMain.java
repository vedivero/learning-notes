package operator;

import java.util.Scanner;

public class DevideZeroMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num != 0) {
            System.out.println(7 / num);
        } else {
            System.out.println("Error");
        }
    }
}
