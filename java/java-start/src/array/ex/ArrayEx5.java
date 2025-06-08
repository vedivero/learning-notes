package array.ex;

import java.util.Scanner;

public class ArrayEx5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("입력받을 숫자의 개수를 입력하세요. : ");
        int arrayLength = scanner.nextInt();

        int[] numbers = new int[arrayLength];

        System.out.println("숫자를 입력하세요. : ");

        int sum = 0;
        double average;
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
            sum += numbers[i];
        }
        average = (double) sum / numbers.length;

        System.out.println("입력한 정수의 합계 : " + sum);
        System.out.println("입력한 정수의 평균 : " + average);
    }
}
