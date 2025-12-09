package array.test;

import java.util.Arrays;

public class Fill2dArrayIntersections {

    public static void main(String[] args) {

        //[
        // [1, 2, 3, 4, 5],
        // [10, 9, 8, 7, 6],
        // [11, 12, 13, 14, 15],
        // [20, 19, 18, 17, 16],
        // [21, 22, 23, 24, 25]
        // ]

        int[][] array = new int[5][5];

        boolean flag = true;
        for (int i = 0; i < 5; i++) {

            if (flag) {
                for (int j = 0; j < 5; j++) {
                    array[i][j] = i * 5 + j + 1;
                    System.out.println("j = " + j);
                }
                flag = false;
            } else {
                int cnt = 1;
                for (int j = 4; j >= 0; j--) {
                    array[i][j] = i * 5 + cnt++;
                    System.out.println("j = " + j);
                }
                flag = true;
            }

        }
        System.out.println("Arrays.deepToString(array) = " + Arrays.deepToString(array));

    }
}
