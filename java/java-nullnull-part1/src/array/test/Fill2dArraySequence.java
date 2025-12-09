package array.test;

import java.util.Arrays;

public class Fill2dArraySequence {

    public static void main(String[] args) {

        int[][] array = new int[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                array[i][j] = i * 5 + j + 1;
            }
        }
        System.out.println("Arrays.deepToString(array) = " + Arrays.deepToString(array));

    }
}
