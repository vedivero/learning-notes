package collection.list.test.ex1;

import java.util.ArrayList;
import java.util.Scanner;

public class ListEx3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<>();

        System.out.println("n개의 정수를 입력하세요. (종료 : 0 입력)");

        while (true) {
            int n = sc.nextInt();
            if (n == 0) {

                int sum = 0;
                for (int i = 0; i < arrayList.size(); i++) {
                    sum += i;
                }
                System.out.println("입력한 정수의 합계 : " + sum);
                System.out.println("입력한 정수의 평균 : " + (double)sum / arrayList.size());
                return;
            }
            arrayList.add(n);
        }
    }
}
