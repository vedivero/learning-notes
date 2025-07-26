package collection.array;

import java.util.Arrays;

public class ArrayMain1 {
    public static void main(String[] args) {

        int[] arr = new int[5];

        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;

        System.out.println(Arrays.toString(arr));

        arr[2] = 10;
        System.out.println(Arrays.toString(arr));

        System.out.println("arr[2] = " + arr[2]);

        int value = 10;
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i + "]" + arr[i]);
            if (arr[i] == value) {
                System.out.println("value : " + value + "찾음");
                break;
            }
        }
    }
}
