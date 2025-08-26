package collection.array;

import java.util.Arrays;

public class ArrayMain2 {

    public static void main(String[] args) {
        int[] arr = new int[5];
        arr[0] = 1;
        arr[1] = 2;
        System.out.println(Arrays.toString(arr));

        System.out.println(" ");
        System.out.println("배열의 첫 번째 위치에 '3' 추가 - O(n)");
        int newValue = 3;
        addFirst(arr, newValue);
        System.out.println(Arrays.toString(arr));

        System.out.println(" ");
        System.out.println("배열의 index(2) 위치에 '4'추가 O(n)");
        int index = 2;
        int value = 4;
        addAtIndex(arr, index, value);
        System.out.println(Arrays.toString(arr));

        System.out.println(" ");
        System.out.println("배열의 마지막 위치에 '5'추가");
        addLastIndex(arr, 5);
        System.out.println(Arrays.toString(arr));

    }

    private static void addFirst(int[] arr, int newValue) {

        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = newValue;
    }

    private static void addAtIndex(int[] arr, int index, int value) {
        for (int i = arr.length - 1; i > index; i--) {
            arr[index] = arr[index-1];
        }
        arr[index] = value;
    }

    private static void addLastIndex(int[] arr, int i) {
        arr[arr.length - 1] = i;
    }

}
