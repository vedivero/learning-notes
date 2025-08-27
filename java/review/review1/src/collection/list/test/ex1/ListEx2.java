package collection.list.test.ex1;

import java.util.ArrayList;
import java.util.Scanner;

public class ListEx2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> arrayList = new ArrayList<>();

        System.out.println("정수를 입력하세요. (0:종료)");
        while (true) {
            int i = sc.nextInt();
            if (i == 0) {
                break;
            }
            arrayList.add(i);
        }

        System.out.println("arrayList = " + arrayList);
    }
}
