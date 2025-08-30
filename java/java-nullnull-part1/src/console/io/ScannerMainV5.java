package console.io;

import java.util.Scanner;

public class ScannerMainV5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String tmp = sc.nextLine();
        System.out.println("tmp = " + tmp);
        System.out.println("sc.next() = " + sc.next());
        System.out.println("END");
    }
}
