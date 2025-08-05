package collection.list.test.ex1;

import java.util.ArrayList;
import java.util.Scanner;

public class ListEx2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<>();

        System.out.println("n개의 정수를 입력하세요. (종료 : 0 입력)");

        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                System.out.println("arrayList = " + arrayList);
                return;
            }
            arrayList.add(n);
        }
    }
}
