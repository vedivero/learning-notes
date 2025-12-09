package array.test;

import java.util.Arrays;

public class Fill2dArraySequence {

    public static void main(String[] args) {

        //[
        // [1, 2, 3, 4, 5],
        // [6, 7, 8, 9, 10],
        // [11, 12, 13, 14, 15],
        // [16, 17, 18, 19, 20],
        // [21, 22, 23, 24, 25]
        // ]
        int[][] array = new int[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                array[i][j] = i * 5 + j + 1;
            }
        }
        System.out.println("Arrays.deepToString(array) = " + Arrays.deepToString(array));

    }
}
