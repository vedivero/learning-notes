package array.test;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {

        int[] array = new int[]{30, 20, 50, 10, 40};

        System.out.println("Arrays.toString(array) = " + Arrays.toString(array));
        System.out.println();

        /*int temp = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] < array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
            System.out.println("Arrays.toString(array) = " + Arrays.toString(array));
        }*/

        int temp = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
            System.out.println("Arrays.toString(array) = " + Arrays.toString(array));
        }


    }
}
