package console.io;

import java.util.Scanner;

public class ScannerMainV1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        try {
            int a = s.nextInt();
        } catch (Exception e) {
            System.out.println("ERROR");
        }

        System.out.println("END");
    }
}
