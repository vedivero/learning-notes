package console.io;

import java.util.Scanner;

public class ScannerMainV3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        String tmp = sc.nextLine();
        System.out.println("data = " + data);
        System.out.println("tmp = " + tmp);
        System.out.println("END");
    }
}
