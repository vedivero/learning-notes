package java.mid2.collection.list.test.ex1;

import java.util.ArrayList;
import java.util.Scanner;

public class ListEx3 {

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

        int sum = sum(arrayList);
        double average = average(arrayList, sum);

        System.out.println("sum = " + sum);
        System.out.println("average = " + average);
    }

    private static int sum(ArrayList<Integer> arrayList) {
        int total = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            total += arrayList.get(i);
        }
        return total;
    }

    private static double average(ArrayList<Integer> arrayList, int sum) {
        double average = 0.0;
        average = (double) sum /arrayList.size();
        return average;
    }
}
