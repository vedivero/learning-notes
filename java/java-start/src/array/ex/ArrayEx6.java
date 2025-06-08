package array.ex;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayEx6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("입력받을 정수의 개수를 입력하세요. : ");
        int arrayLength = scanner.nextInt();

        int[] numbers = new int[arrayLength];

        System.out.println("정수를 입력하세요.");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }

        int minNumber = numbers[0];
        int maxNumber = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (minNumber > numbers[i]) {
                minNumber = numbers[i];
            }
            if (maxNumber < numbers[i]) {
                maxNumber = numbers[i];
            }
        }

        System.out.println("가장 작은 정수 : " + minNumber);
        System.out.println("가장 큰 정수 : " + maxNumber);
    }
}
